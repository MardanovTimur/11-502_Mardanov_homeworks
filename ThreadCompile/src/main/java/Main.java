import java.util.Scanner;

public class Main {

    public static Character[] symbols;
    public static StackClass stack = new StackClass();

    public static void main(String[] args) {

        repartStringToChar();

        RecThread threadA = new RecThread(symbols, stack.getIndex());
        threadA.start();

        RecThread threadB = new RecThread(symbols, stack.getIndex());
        threadB.start();

        RecThread threadC = new RecThread(symbols, stack.getIndex());
        threadC.start();

        RecThread threadD = new RecThread(symbols, stack.getIndex());
        threadD.start();

        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.print("Поток завершился!");
        }

        System.out.println(stack.isEmpty());
    }

    public static void repartStringToChar() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        symbols = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            symbols[i] = s.charAt(i);
        }
    }
}

