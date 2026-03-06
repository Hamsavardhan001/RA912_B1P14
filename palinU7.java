import java.util.ArrayDeque;
import java.util.Deque;

public class palinU7 {
    
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.5.0";
    
    public static void main(String[] args) {
        displayWelcomeMessage();
        
        String[] testStrings = {
            "madam",
            "racecar",
            "hello",
            "level",
            "A man a plan a canal Panama",
            "12321",
            "Was it a car or a cat I saw"
        };
        
        for (String testString : testStrings) {
            System.out.println("\n" + "=".repeat(60));
            checkPalindromeWithDeque(testString);
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println(APP_NAME + " execution completed.");
    }
    
    private static void displayWelcomeMessage() {
        System.out.println("=".repeat(60));
        System.out.println(APP_NAME + " - Version " + APP_VERSION);
        System.out.println("Using Deque (Double-Ended Queue)");
        System.out.println("=".repeat(60));
    }
    
    private static void checkPalindromeWithDeque(String input) {
        System.out.println("Input: \"" + input + "\"");
        
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        System.out.println("Cleaned: \"" + cleanInput + "\"");
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for (int i = 0; i < cleanInput.length(); i++) {
            deque.addLast(cleanInput.charAt(i));
        }
        
        System.out.println("Deque initialized: " + formatDeque(deque));
        
        boolean isPalindrome = true;
        int comparisons = 0;
        
        while (deque.size() > 1) {
            comparisons++;
            char first = deque.removeFirst();
            char last = deque.removeLast();
            
            System.out.println("  Comparison " + comparisons + 
                             ": Front '" + first + "' vs Rear '" + last + "'");
            
            if (first != last) {
                System.out.println("  Mismatch found");
                isPalindrome = false;
                break;
            }
            
            if (deque.size() > 1) {
                System.out.println("  Deque now: " + formatDeque(deque));
            }
        }
        
        if (deque.size() == 1) {
            System.out.println("  Middle character '" + deque.getFirst() + "' remains (no comparison needed)");
        }
        
        System.out.println("\nResult: \"" + input + "\" is " + 
                         (isPalindrome ? "a palindrome" : "not a palindrome"));
        System.out.println("Comparisons performed: " + comparisons);
    }
    
    private static String formatDeque(Deque<Character> deque) {
        if (deque.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (Character c : deque) {
            sb.append(c).append(", ");
        }
        return sb.substring(0, sb.length() - 2) + "]";
    }
}
