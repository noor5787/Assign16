package in.ineuron.in;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStackOrder {
    public static boolean checkQueueOrder(Queue<Integer> queue) {
        int expectedNumber = 1;
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            if (queue.peek() == expectedNumber) {
                queue.poll();
                expectedNumber++;
            } else if (!stack.isEmpty() && stack.peek() == expectedNumber) {
                stack.pop();
                expectedNumber++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty() && stack.peek() == expectedNumber) {
            stack.pop();
            expectedNumber++;
        }

        return queue.isEmpty() && stack.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(5);
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        System.out.println(checkQueueOrder(queue1)); // Output: Yes

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(5);
        queue2.add(1);
        queue2.add(2);
        queue2.add(6);
        queue2.add(3);
        queue2.add(4);
        System.out.println(checkQueueOrder(queue2)); // Output: No
    }
}
