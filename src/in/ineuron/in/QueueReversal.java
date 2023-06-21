package in.ineuron.in;
import java.util.LinkedList;
import java.util.Queue;

public class QueueReversal {
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        if (k == 0) {
            return;
        }

        // Create a temporary stack
        LinkedList<Integer> stack = new LinkedList<>();

        // Push the first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Move the remaining elements to the rear of the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        queue.offer(10);

        int k = 5;

        System.out.println("Original Queue: " + queue);
        reverseFirstKElements(queue, k);
        System.out.println("Reversed Queue: " + queue);
    }
}
