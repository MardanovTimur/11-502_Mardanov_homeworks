import java.util.Arrays;
import java.util.Scanner;

public class Sparkle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = s;
                s++;
            }
        }
        int b[][] = new int[a.length][a.length];
        boolean u = true, d = false, r = false, l = false, f = true;
        boolean pos[] = {r, d, l, u};
        int o = 0, p = 0;
        int i, j, divider = 0, SIZE = 0, counter = 0;
        counter = 1;
        SIZE = (a.length - counter) * 4;
        divider = a.length - counter;
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a.length; j++) {
                if (SIZE == 0) {
                    counter++;
                    divider = a.length - 2 * (counter - 1) - 1;
                    SIZE = divider * 4;
                    f = false;
                }
                b[o][p] = a[i][j];
                if (SIZE != 0) {
                    if ((SIZE % divider == 0 || SIZE == 1) && f) {
                        pos = getPos(pos);
                    }
                }
                if (pos[0]) {
                    p++;
                }
                if (pos[1]) {
                    o++;
                }
                if (pos[2]) {
                    p--;
                }
                if (pos[3]) {
                    o--;
                }
                f = true;
                SIZE--;
            }
        }
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean[] getPos(boolean[] pos) {
        if (pos[3] == true) {
            pos[0] = true;
            pos[3] = false;
        } else {
            for (int i = 0; i < 4; i++) {
                if (pos[i] == true) {
                    pos[i + 1] = true;
                    pos[i] = false;
                    break;
                }
            }
        }
        return pos;
    }


}
