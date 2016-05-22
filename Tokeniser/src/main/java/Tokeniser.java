import java.util.Observable;
import java.util.Observer;

/**
 * Created by Тимур on 16.05.2016.
 */
public class Tokeniser {
    public static void process(String text) {
        TokeniserObserver tokeniserObserver = new TokeniserObserver();
        String[] s = text.split(" ");
        int countS = 0;
        while (countS < s.length) {
            String newText = new String();
            String sign = new String();
            String Digits = new String();
            if (s[countS]!=null) {
                for (int i = 0; i < s[countS].length(); i++) {
                    if ((s[countS].codePointAt(i) >= 65 && s[countS].codePointAt(i) <= 90) ||
                            (s[countS].codePointAt(i) >= 97 && s[countS].codePointAt(i) <= 122)) {
                        newText += s[countS].charAt(i);
                    }
                    if (s[countS].codePointAt(i) >= 33 && s[countS].codePointAt(i) <= 47) {
                        sign += s[countS].charAt(i);
                    }
                    if (s[countS].codePointAt(i) >= 48 && s[countS].codePointAt(i) <= 57) {
                        Digits += s[countS].charAt(i);
                    }
                }
                tokeniserObserver.handleDigits(Digits);
                tokeniserObserver.handleLetter(newText);
                tokeniserObserver.handleSign(sign);
                countS++;
            }
        }
    }
}
