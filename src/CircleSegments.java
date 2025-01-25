import javax.swing.*;
import java.awt.*;

public class CircleSegments extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smooth graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define circle parameters
        int centerX = 150;
        int centerY = 150;
        int radius = 100;
        int diameter = radius * 2;

        // Define percentages for each segment
        int[] percentages = {40, 30, 20, 10};

        // Calculate angles from percentages
        int totalPercentage = 100;
        int startAngle = 0;

        for (int i = 0; i < percentages.length; i++) {
            int arcAngle = (int) (360.0 * percentages[i] / totalPercentage);

            // Draw the segment
            g2d.setColor(getSegmentColor(i)); // Assign a color to each segment
            g2d.fillArc(centerX - radius, centerY - radius, diameter, diameter, startAngle, arcAngle);

            // Calculate the position for the percentage label
            double theta = Math.toRadians(startAngle + arcAngle / 2.0);
            int labelX = (int) (centerX + radius / 1.5 * Math.cos(theta));
            int labelY = (int) (centerY - radius / 1.5 * Math.sin(theta));

            // Draw the percentage label
            g2d.setColor(Color.BLACK);
            g2d.drawString(percentages[i] + "%", labelX - 10, labelY + 5);

            // Update start angle for the next segment
            startAngle += arcAngle;
        }

        // Draw the circle outline
        g2d.setColor(Color.BLACK);
        g2d.drawOval(centerX - radius, centerY - radius, diameter, diameter);
    }

    // Method to return a unique color for each segment
    private Color getSegmentColor(int index) {
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
        return colors[index % colors.length];
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle with Segments");
        CircleSegments panel = new CircleSegments();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
