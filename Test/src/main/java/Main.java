/**
 * Created by Тимур on 25.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        TestC testC = new TestC();
        testC.setS("Hello");
        System.out.println(testC.getS());
        TestC testC1 = new TestC();
        System.out.println(testC1.getS());
    }
}
