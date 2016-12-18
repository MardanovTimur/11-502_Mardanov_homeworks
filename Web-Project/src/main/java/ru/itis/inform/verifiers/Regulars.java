package ru.itis.inform.verifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Тимур on 16.12.2016.
 */
// Проверка на число регуляркой...
public class Regulars {
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isNumber(String line) {
        pattern = Pattern.compile("\\d+");
        matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
