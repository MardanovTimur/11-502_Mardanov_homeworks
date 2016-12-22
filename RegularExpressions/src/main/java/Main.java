/**
 * Created by Тимур on 15.12.2016.
 */
import java.util.Scanner;
import java.util.regex.*;
public class Main {
    private static Pattern pattern;
    private static Matcher matcher;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(check(line));
        if (check(line)) {
            System.out.println("Before @ : "+getUndo(line));
            System.out.println("After @ : "+getAfter(line));
        }

    }

    private static String getAfter(String line) {
        return matcher.group(2);
    }

    private static String getUndo(String line) {
        return matcher.group(1);
    }

    public static boolean check(String s) {
        pattern = Pattern.compile("^\\d-?\\d\\d\\d-?+\\d$");
        matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
