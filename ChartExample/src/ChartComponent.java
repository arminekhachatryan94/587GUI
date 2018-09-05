import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class ChartComponent extends JComponent {
    private ArrayList<Double> values;
    private double maxValue;

    private final int GAP = 5;
    private final int BAR_HEIGHT = 10;

    public ChartComponent(double maxValue) {
        this.maxValue = maxValue;
        values = new ArrayList<Double>();
    }

    public void append(double value) {
        values.add(value);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        int y = GAP;
        int barWidth = 0;
        for(double value : values ) {
            barWidth = (int)(getWidth() * value / maxValue);
            g.fillRect(0, y, barWidth, BAR_HEIGHT);
            y = y + BAR_HEIGHT + GAP;
        }
    }
}
