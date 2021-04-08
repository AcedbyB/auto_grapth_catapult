import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

public class drawing_2 extends drawing {
    int angle;
    int v;
    double gravity = 9.8;
    double reach = 0.0;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Point2D.Double point = new Point2D.Double(0, 400);
        int i = 0;
        do {
            i++;
            double angle_1 = Math.toRadians(angle);
            reach = i * Math.tan(angle_1);
            double tmp = gravity * i * i;
            double tmp2 = 2 * (v * Math.cos(angle_1)) * (v * Math.cos(angle_1));
            tmp /= tmp2;
            reach -= tmp;
            Point2D.Double point1 = new Point2D.Double(i, 400 - reach);
            Line2D.Double ln = new Line2D.Double(point, point1);
            g2.draw(ln);
            point = point1;
        } while (reach >= 0 && i < 600);
    }
}