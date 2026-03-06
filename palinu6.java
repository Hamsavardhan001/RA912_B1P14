import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class palinu6 {
    
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.4.0";
    
    public static void main(String[] args) {
        displayWelcomeMessage();
        
        String[] testStrings = {
            "madam",
            "racecar",
            "hello",
            "level",
            "A man a plan a canal Panama",
            "12321"
        };
        
        for (String testString : testStrings) {
            System.out.println("\n" + "=".repeat(60));
            demonstrateFIFOvsLIFO(testString);
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println(APP_NAME + " execution completed.");
    }
    
    private static void displayWelcomeMessage() {
        System.out.println("=".repeat(60));
        System.out.println(APP_NAME + " - Version " + APP_VERSION);
        System.out.println("FIFO (Queue) vs LIFO (Stack) Demonstration");
        System.out.println("=".repeat(60));
    }
    
    private static void demonstrateFIFOvsLIFO(String input) {
        System.out.println("Input: \"" + input + "\"");
        
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        System.out.println("Cleaned: \"" + cleanInput + "\"");
        
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        
        System.out.println("\nFilling Phase:");
        for (int i = 0; i < cleanInput.length(); i++) {
            char c = cleanInput.charAt(i);
            queue.offer(c);
            stack.push(c);
            System.out.println("  Enqueued: " + c + " | Pushed: " + c);
        }
        
        System.out.println("\nQueue state (front to rear): " + formatQueue(queue));
        System.out.println("Stack state (bottom to top): " + formatStack(stack));
        
        System.out.println("\nEmptying Phase:");
        StringBuilder queueOrder = new StringBuilder();
        StringBuilder stackOrder = new StringBuilder();
        boolean isPalindrome = true;
        int comparisons = 0;
        
        while (!queue.isEmpty() && !stack.isEmpty()) {
            comparisons++;
            char dequeued = queue.poll();
            char popped = stack.pop();
            
            queueOrder.append(dequeued);
            stackOrder.append(popped);
            
            System.out.println("  Comparison " + comparisons + 
                             ": Dequeued '" + dequeued + "' vs Popped '" + popped + "'");
            
            if (dequeued != popped) {
                System.out.println("  Mismatch found");
                isPalindrome = false;
            }
        }
        
        System.out.println("\nResults:");
        System.out.println("  Original: " + cleanInput);
        System.out.println("  Queue order (FIFO): " + queueOrder.toString());
        System.out.println("  Stack order (LIFO): " + stackOrder.toString());
        System.out.println("  Is palindrome: " + isPalindrome);
        System.out.println("  Comparisons made: " + comparisons);
    }
    
    private static String formatQueue(Queue<Character> queue) {
        if (queue.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (Character c : queue) {
            sb.append(c).append(", ");
        }
        return sb.substring(0, sb.length() - 2) + "]";
    }
    
    private static String formatStack(Stack<Character> stack) {
        if (stack.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i)).append(", ");
        }
        return sb.substring(0, sb.length() - 2) + "]";
    }
}
