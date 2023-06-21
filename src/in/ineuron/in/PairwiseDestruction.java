package in.ineuron.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PairwiseDestruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sequence of words:");
        String input = scanner.nextLine();
        
        int remainingWords = countRemainingWords(input);
        System.out.println("Number of words left after pairwise destruction: " + remainingWords);
    }
    
    private static int countRemainingWords(String input) {
        String[] words = input.split(" ");
        Stack<String> stack = new Stack<>();
        
        for (String word : words) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop(); // Destroy the matching word
            } else {
                stack.push(word); // Add the word to the stack
            }
        }
        
        return stack.size();
    }
}
