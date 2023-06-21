package in.ineuron.in;
import java.util.Stack;

public class NumberReverser {
    public static void main(String[] args) {
        int number = 365;
        int reversedNumber = reverseNumber(number);
        System.out.println("Input: " + number);
        System.out.println("Reversed Output: " + reversedNumber);

        number = 6899;
        reversedNumber = reverseNumber(number);
        System.out.println("Input: " + number);
        System.out.println("Reversed Output: " + reversedNumber);
    }

    public static int reverseNumber(int number) {
        Stack<Integer> stack = new Stack<>();
        
        // Push each digit of the number onto the stack
        while (number > 0) {
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }

        int reversedNumber = 0;
        int multiplier = 1;
        
        // Pop digits from the stack and build the reversed number
        while (!stack.isEmpty()) {
            reversedNumber += stack.pop() * multiplier;
            multiplier *= 10;
        }
        
        return reversedNumber;
    }
}
