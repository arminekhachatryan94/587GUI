import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

// for listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildFrame extends JFrame {
    private static final int FRAME_WIDTH = 500; // can be public
    private static final int FRAME_HEIGHT = 500;

    private JPanel panel;
    private JButton button;
    private JLabel label;

    private static final double INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private double balance;

    public BuildFrame() {
        balance = INITIAL_BALANCE;
        createFrame();
        addListeners();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private class ClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            double interest = balance * INTEREST_RATE/100;
            balance += interest;
            label.setText("Balance: " + balance);
        }
    }

    private void addListeners(){
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
    }

    private void createFrame() {
        // order matters
        // everything gets added to the panel, then everything gets added
        panel = new JPanel();
        button = new JButton("Click me"); // default constructor?
        label = new JLabel("This is my label.");
        panel.add(button); // order matters
        panel.add(label);
        add(panel); // frame adds panel
    }
}

// look up java swing layouts