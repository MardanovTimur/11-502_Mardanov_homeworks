import java.util.Stack;

/**
 * Created by Тимур on 25.05.2016.
 */
public class StackClass {
    private Stack<Character> stack;

    private static int index = 0;

    public StackClass(Stack<Character> stack) {
        this.stack = stack;
    }

    public StackClass() {
        stack = new Stack<Character>();
    }

    public static int getIndex() {
        return index;
    }

    public Stack<Character> getStack() {
        return stack;
    }

    public void push(char c) {
        stack.push(c);
        index++;
    }

    public char peek() {
        return stack.peek();
    }

    public void pop() {
        stack.pop();
        index++;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
