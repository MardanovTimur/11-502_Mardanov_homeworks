/**
 * Created by Тимур on 16.05.2016.
 */
public class TokeniserObserver {
    public void handleDigits(String digits) {
        if (!digits.equals("")) {
            System.out.println("Digits, " + digits);
        }
    }

    public void handleLetter(String letter) {
        if (!letter.equals("")) {
            System.out.println("Letter, " + letter);
        }
    }

    public void handleSign(String sign) {
        if (!sign.equals("")) {
            System.out.println("Sign, " + sign);
        }
    }
}
