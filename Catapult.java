import java.lang.Math;

public class Catapult {
    int v;
    int angle;
    double g = 9.8;
    double reach = 0.0;
    int score = 0;
    public void shoot(int d, int height) {
        score--;
        double angle_1 = Math.toRadians(angle);
        reach = d * Math.tan(angle_1);
        double tmp = g * d * d;
        double tmp2 = 2 * (v * Math.cos(angle_1)) * (v * Math.cos(angle_1));
        tmp /= tmp2;
        reach -= tmp;
    }
}
