package Core;

import java.util.Scanner;

public class BeanFactory {

    /**
     * Create Bean and returns it.
     *
     * @return HangmanBean
     */
    public static HangmanBean getHangmanBean() {
        return new HangmanBean();
    }

    /**
     * Create scanner
     *
     * @return Scanner
     */
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
