import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;


public class Play {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int round = 1;
        String s;
        Catapult cp = new Catapult();
        Announcer ann = new Announcer();
        JFrame window = new JFrame();
        window.setTitle("Aced by B");
        window.setSize(600,600);
        drawing dr = new drawing();
        drawing_2 dr2 = new drawing_2();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(round++ > 0) {
            System.out.println();
            window.getContentPane().removeAll();
            Wall w = new Wall();
            dr.height = w.height;
            dr.dis = w.dis;
            window.add(dr);
            Timer myTimer = new Timer();
            TimerTask Task = new TimerTask() {
                public void run() {
                    w.dis--;
                    dr.dis = w.dis;
                    dr.repaint();
                }
            };
            //myTimer.scheduleAtFixedRate(Task,0,500);
            System.out.println("Is this too hard? Type \"Skip\" to pass the round or \"Quit\" to forfeit");
            String V = sc.next();
            if(V.equals("Skip") == true) {
                myTimer.cancel();
                continue;
            }
            if(V.equals("Quit") == true) {
                myTimer.cancel();
                return;
            }
            String Angle = sc.next();
            cp.v = Integer.parseInt(V);
            cp.angle = Integer.parseInt(Angle);
            myTimer.cancel();
            cp.shoot(w.dis, w.height);
            ann.respond(cp,w);
            System.out.println("CURRENT SCORE: " + cp.score);
            dr.v = cp.v;
            dr.angle = cp.angle;
            dr.repaint();
            s = sc.nextLine();
        }
    }
}
