/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;

/**
 *
 * @author sevak
 */


public class MyGUIProject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new ConstructedFrame();            
        frame.setTitle("My First GUI App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                      
        frame.setVisible(true);                
    }    
}
