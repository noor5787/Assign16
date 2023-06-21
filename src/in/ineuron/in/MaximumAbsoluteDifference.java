package in.ineuron.in;
import java.util.Stack;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {2, 1, 8};
        int maxDifference = findMaxAbsoluteDifference(arr);
        System.out.println("Maximum Absolute Difference: " + maxDifference);

        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};
        int maxDifference2 = findMaxAbsoluteDifference(arr2);
        System.out.println("Maximum Absolute Difference: " + maxDifference2);

        int[] arr3 = {5, 1, 9, 2, 5, 1, 7};
        int maxDifference3 = findMaxAbsoluteDifference(arr3);
        System.out.println("Maximum Absolute Difference: " + maxDifference3);
    }

    public static int findMaxAbsoluteDifference(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmaller[i] = 0;
            } else {
                leftSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmaller[i] = 0;
            } else {
                rightSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        int maxDifference = 0;
        for (int i = 0; i < n; i++) {
            int difference = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDifference = Math.max(maxDifference, difference);
        }

        return maxDifference;
    }
}
