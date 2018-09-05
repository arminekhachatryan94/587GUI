import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChartFrame extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private static final double INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;
    private static final int CHART_WIDTH = 300;
    private static final int CHART_HEIGHT = 300;
    private static final int FIELD_WIDTH = 10;

    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JTextField text;
    private double balance;
    private ChartComponent chart;

    public ChartFrame() {
        balance = INITIAL_BALANCE;
        chart = new ChartComponent(3 * INITIAL_BALANCE);
        chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
        chart.append(INITIAL_BALANCE);
        createTextField();
        createButton();
        createPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField(){
        label = new JLabel("Interest rate: ");
        text = new JTextField(FIELD_WIDTH);
        text.setText(""+INTEREST_RATE);
    }

    private void createButton(){
        button  = new JButton("Add Interest");
        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }

    private class AddInterestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double rate = 0;
            try {
                rate = Double.parseDouble(text.getText());
            } catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(panel,"Bad number, try again");
                return;
            }
            double interest = balance * rate / 100;
            balance += interest;
            chart.append(balance);
        }
    }

    private void createPanel(){
        panel = new JPanel();
        panel.add(label);
        panel.add(text);
        panel.add(button);
        panel.add(chart);
        add(panel);
    }

}
