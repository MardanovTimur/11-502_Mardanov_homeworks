package ru.itis.inform;

/**
 * Created by Тимур on 27.04.2016.
 */
public class Tested {
    public static void main(String[] argc) {
        Map<String,String> map = new HashMap<String, String>(4);
        map.put("value","2");
        map.put("key","2");
        map.put("kez","3");
        map.put("keu","5");
        map.put("zar","r");
        Object c = map.get("keu");
        Object d = map.get("kez");

    }
}
