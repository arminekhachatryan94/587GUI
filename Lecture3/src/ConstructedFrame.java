/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author sevak
 * 
 */
public class ConstructedFrame extends JFrame {
    
    private JButton button;
    private JLabel label;   
    private JPanel panel;
    private JTextField textField;
    private KeyListener keyListener;
    private JTextArea textArea;

    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem exit;
    
    private double balance;    

    private static final int ROWS = 10;
    private static final int COLS = 30;

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    
    private static final double INTEREST_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;
    
    public ConstructedFrame() {
        
        balance = INITIAL_BALANCE;
        
        createTextArea();
        createKeyListener();
        createTextField();
        buildMenu();
        createFrame();
        addMenuListeners();
        addListeners();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);  
    }

    private void buildMenu() {
        bar = new JMenuBar();
        menu = new JMenu("app");
        exit = new JMenuItem("Exit");
        menu.add(exit);
        bar.add(menu);
    }

    private void addMenuListeners() {
        exit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitActionPerformed();
            }
        });
    }

    private void exitActionPerformed() {
        System.exit(0);
    }

    private void createTextArea() {
        textArea = new JTextArea(ROWS, COLS);
        textArea.setText("Balance: " + balance+"\n");
        textArea.setEditable(false);
    }
    
    private void createKeyListener() {
        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) { // printable characters; f1, f2, shift, control, alt/option, etc. are not
                System.out.println("keyTyped: " + ke.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                System.out.println("keyPressed: " + ke.getKeyCode());
                handleKeyPressed(ke.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        };
    }
    
    private void handleKeyPressed(int keyCode) {
        switch(keyCode) {
            case 10:
                updateTextField();
                break;
            case 27:
                // Escape key
                break;
        }
        
    }
    
    private void createTextField() {
        final int FIELD_LEGTH = 10;
        textField = new JTextField(FIELD_LEGTH);
        textField.addKeyListener(keyListener);
        textField.setText(String.valueOf(INTEREST_RATE));
    }
    
    private void updateTextField() {
        double rate = 0;
        try {
            rate = Double.parseDouble(textField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Bad rate! Try again.");
        }
        double interest = balance * rate / 100;
        balance += interest;
        String balanceStr = "Balance: " + balance;
        label.setText(balanceStr);
        textArea.append(balanceStr+"\n");
    }
    
    private class ClickListener implements ActionListener {    
        @Override
        public void actionPerformed(ActionEvent ae) {
            updateTextField();
        }    
    }
    
    private void createFrame() {
        button = new JButton("Calculate");
        label = new JLabel(String.valueOf(balance));
        panel = new JPanel();                          
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        JScrollPane myScrollPane = new JScrollPane(textArea);
        panel.add(myScrollPane);
                        
        add(panel);
        setJMenuBar(bar);
    }
    
    private void addListeners() {
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
    }
    
}
