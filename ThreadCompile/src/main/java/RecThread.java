import java.util.EmptyStackException;

public class RecThread extends Thread {

    private Character s;
    private Character[] characters;
    private int size;
    private String name;

    public RecThread() {
    }

    public RecThread(Character[] characters, int index) {
        this.characters = characters;
        if (index < characters.length)
            s = characters[index];
        else {
            s = ' ';
        }
        this.size = characters.length;
    }

    @Override
    public void run() {
        while (StackClass.getIndex() < size && s != ' ') {
            if (Main.stack.isEmpty()) {
                Main.stack.push(s);
                System.out.println("This -> " + this.getName() + " added :" + s);
            } else if (((int) Main.stack.peek() == (int) s - 2) ||
                    (Main.stack.peek() == '(' && (int) Main.stack.peek() == (int) s - 1)) {
                Main.stack.pop();
                try {
                    System.out.println("This -> " + this.getName() + " deleted :" + Main.stack.peek() + ", " + s);
                } catch (EmptyStackException e) {}
            } else {
                Main.stack.push(s);
                try {
                    System.out.println("This -> " + this.getName() + " added :" + s);
                } catch (EmptyStackException e) {

                }
            }
            if (StackClass.getIndex() < size)
                s = characters[StackClass.getIndex()];
        }
    }
}