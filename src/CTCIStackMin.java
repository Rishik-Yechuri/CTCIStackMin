import java.util.Stack;

public class CTCIStackMin {
    public static void main(String[] args) {
        try {
            CTCIStackMin obj = new CTCIStackMin();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(8);
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
    }

    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minValues = new Stack<>();

        public int pop() {
            minValues.pop();
            return stack.pop();
        }

        public void push(int value) {
            if (stack.isEmpty()) {
                minValues.push(value);
            } else if (value < minValues.peek()) {
                minValues.push(value);
            } else {
                minValues.push(minValues.peek());
            }
            stack.push(value);
        }

        public int min() {
            return minValues.peek();
        }
    }
}
