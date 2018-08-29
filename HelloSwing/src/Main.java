import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame frame = new BuildFrame();
        frame.setTitle("My first GUI app");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("Hello world");
    }
}
