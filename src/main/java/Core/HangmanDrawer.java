package Core;

import Constants.Drawer;

public class HangmanDrawer {

    private static HangmanDrawer instance = new HangmanDrawer();

    public static HangmanDrawer getInstance() {
        return instance;
    }

    public void draw(int attempt) {
        switch (attempt) {
            case 0:
                display(Drawer.ZERO_ATTEMPT);
                break;
            case 1:
                display(Drawer.FIRST_ATTEMPT);
                break;
            case 2:
                display(Drawer.SECOND_ATTEMPT);
                break;
            case 3:
                display(Drawer.THIRD_ATEMPT);
                break;
            case 4:
                display(Drawer.FOURTH_ATTEMPT);
                break;
            case 5:
                display(Drawer.FIFTH_ATTEMPT);
                break;
            case 6:
                display(Drawer.SIXTH_ATTEMPT);
                break;
            case 7:
                display(Drawer.SEVENTH_ATTEMPT);
                break;
            case 8:
                display(Drawer.EIGTH_ATTEMPT);
                break;
            case 9:
                display(Drawer.NINTH_ATTEMPT);
                break;
            case 10:
                display(Drawer.TENTH_ATTEMPTH);
                break;
            default:
                throw new IllegalArgumentException("No drawings for attempt: " + attempt);
        }
    }

    public void display(Drawer drawer) {
        System.out.println(drawer.getImageInAscii());
    }
}
