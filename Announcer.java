public class Announcer {

    public void respond(Catapult cp, Wall w) {
        double reach = cp.reach;
        int height = w.height;
        int score = cp.score;
        if (reach <= 0) {
            System.out.println("Not even close... At least touch the wall would you? :(");
            score -= 3;
            return;
        } else if (reach <= height) {
            if (reach == height)
                System.out.println("Touched the top! Too bad");
            else
                System.out.println("U broke the wall! That would cost you some points to build it again.");
            System.out.print("Your shot was " + (height - reach) +" meters from the top of the wall   ");
            score -= 2;
            return;
        } else if (reach <= height + 30) {
            System.out.println("Passin' with grace");
            score += 5;
        } else {
            System.out.println("Plenty of room");
            score += 2;
        }
        System.out.print("Your shot was " + (reach - height) + " meters above the wall     ");
        cp.score = score;
    }
}
