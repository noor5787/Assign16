package in.ineuron.in;
import java.util.Stack;

class Main {
    public static void deleteMiddleElement(Stack<Integer> stack) {
        int size = stack.size();
        int middle = size / 2 + 1;

        deleteMiddleElementUtil(stack, middle);
    }

    private static void deleteMiddleElementUtil(Stack<Integer> stack, int middle) {
        // Base case: reached the middle element
        if (middle == 1) {
            stack.pop();
            return;
        }

        // Remove current element and recursively call the function
        int temp = stack.pop();
        deleteMiddleElementUtil(stack, middle - 1);

        // Insert the removed element back after the recursive calls
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        System.out.println("Original Stack: " + stack1);
        deleteMiddleElement(stack1);
        System.out.println("Modified Stack: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        System.out.println("Original Stack: " + stack2);
        deleteMiddleElement(stack2);
        System.out.println("Modified Stack: " + stack2);
    }
}
