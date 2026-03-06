import java.util.Stack;

/**
 * PalindromeChecker Application
 * This application checks if a string is a palindrome using Stack data structure
 * Stack follows LIFO (Last In First Out) principle, naturally reversing the order
 */
public class palinU5 {
    
    // Application constants
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.3.0";
    
    /**
     * Main method - Entry point of the application
     * Demonstrates palindrome checking using Stack data structure
     * 
     * @param args command line arguments (not used in this version)
     */
    public static void main(String[] args) {
        // Display welcome message
        displayWelcomeMessage();
        
        // Test strings to check
        String[] testStrings = {
            "madam",
            "racecar",
            "hello",
            "level",
            "java",
            "A man a plan a canal Panama",
            "12321",
            "Was it a car or a cat I saw",
            "Never odd or even"
        };
        
        // Test each string using Stack approach
        for (String testString : testStrings) {
            System.out.println("\n" + "▀".repeat(70));
            checkPalindromeWithStack(testString);
        }
        
        // Demonstrate Stack operations visually
        System.out.println("\n" + "▀".repeat(70));
        demonstrateStackOperations("MADAM");
        
        // Compare different approaches
        System.out.println("\n" + "▀".repeat(70));
        System.out.println("📊 DATA STRUCTURE COMPARISON:");
        compareApproaches("racecar");
        
        System.out.println("\n" + "▀".repeat(70));
        System.out.println(APP_NAME + " execution completed. Exiting...");
    }
    
    /**
     * Displays the welcome message and application information
     */
    private static void displayWelcomeMessage() {
        System.out.println("▀".repeat(80));
        System.out.println("     WELCOME TO THE " + APP_NAME.toUpperCase());
        System.out.println("▀".repeat(80));
        System.out.println("Version: " + APP_VERSION);
        System.out.println("Method: Stack Data Structure (LIFO)");
        System.out.println("⭐ Key Concepts: Push, Pop, LIFO Principle, Automatic Reversal");
        System.out.println("📚 Data Structure: java.util.Stack<E>");
        System.out.println("─".repeat(80));
    }
    
    /**
     * Checks if a string is a palindrome using a Stack
     * Stack naturally reverses the order of characters due to LIFO principle
     * 
     * @param input the string to check
     */
    private static void checkPalindromeWithStack(String input) {
        System.out.println("\n🔍 ANALYZING: \"" + input + "\"");
        
        // Step 1: Clean the string (remove spaces and convert to lowercase)
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        System.out.println("   📝 Cleaned version: \"" + cleanInput + "\"");
        
        // Step 2: Create a Stack to store characters
        Stack<Character> charStack = new Stack<>();
        System.out.println("   📦 Created empty Stack<Character>");
        
        // Step 3: PUSH operation - Push all characters onto the stack
        System.out.println("\n   ⬆️ PUSH PHASE (Adding characters to stack):");
        for (int i = 0; i < cleanInput.length(); i++) {
            char currentChar = cleanInput.charAt(i);
            charStack.push(currentChar);
            System.out.printf("      Pushed: '%c' → Stack now: %s%n", 
                            currentChar, formatStack(charStack));
        }
        
        // Show stack state after all pushes
        System.out.println("\n   📊 Stack after all pushes (TOP is last element):");
        System.out.println("      " + formatStackWithTop(charStack));
        
        // Step 4: POP operation - Compare characters by popping from stack
        System.out.println("\n   ⬇️ POP PHASE (Removing and comparing characters):");
        boolean isPalindrome = true;
        int comparisons = 0;
        
        // Create a StringBuilder to build the reversed string from popped characters
        StringBuilder reversed = new StringBuilder();
        
        for (int i = 0; i < cleanInput.length(); i++) {
            comparisons++;
            
            // POP operation - removes and returns the top element
            char poppedChar = charStack.pop();
            char originalChar = cleanInput.charAt(i);
            reversed.append(poppedChar);
            
            System.out.printf("      Popped: '%c' (from top) | Original[%d]: '%c' | ", 
                            poppedChar, i, originalChar);
            
            if (poppedChar == originalChar) {
                System.out.print("✓ Match");
            } else {
                System.out.print("✗ Mismatch");
                isPalindrome = false;
            }
            
            System.out.println(" | Stack now: " + 
                             (charStack.isEmpty() ? "[empty]" : formatStack(charStack)));
        }
        
        // Step 5: Display results
        displayStackResults(input, cleanInput, reversed.toString(), isPalindrome, comparisons);
    }
    
    /**
     * Displays detailed results of the Stack-based palindrome check
     * 
     * @param original the original input string
     * @param cleaned the cleaned version
     * @param reversed the string built from popped characters
     * @param isPalindrome whether it's a palindrome
     * @param comparisons number of comparisons made
     */
    private static void displayStackResults(String original, String cleaned, 
                                          String reversed, boolean isPalindrome, int comparisons) {
        System.out.println("\n   📋 STACK ANALYSIS RESULTS:");
        
        // Show reversal effect
        System.out.println("      Original (cleaned): \"" + cleaned + "\"");
        System.out.println("      Reversed (from stack): \"" + reversed + "\"");
        System.out.println("      Total comparisons: " + comparisons);
        
        // Demonstrate LIFO principle
        System.out.println("\n   🔄 LIFO (Last In First Out) Demonstration:");
        System.out.println("      Last character in ('" + cleaned.charAt(cleaned.length()-1) + 
                          "') → First character out ('" + reversed.charAt(0) + "')");
        System.out.println("      First character in ('" + cleaned.charAt(0) + 
                          "') → Last character out ('" + reversed.charAt(reversed.length()-1) + "')");
        
        // Visual representation
        System.out.println("\n   📊 Stack Visualization:");
        visualizeStackProcess(cleaned);
        
        // Verdict
        System.out.print("\n   ⚖️ VERDICT: ");
        if (isPalindrome) {
            System.out.println("✅ \"" + original + "\" IS a palindrome!");
            System.out.println("      ✓ Stack push/pop operations successful");
            System.out.println("      ✓ LIFO principle correctly reversed the string");
            if (!original.equals(cleaned)) {
                System.out.println("      (After removing spaces and ignoring case)");
            }
        } else {
            System.out.println("❌ \"" + original + "\" is NOT a palindrome.");
            System.out.println("      ✗ Stack comparison revealed mismatch");
            System.out.println("      ✗ Original and reversed strings differ");
        }
    }
    
    /**
     * Visualizes the stack process with ASCII art
     * 
     * @param str the string being processed
     */
    private static void visualizeStackProcess(String str) {
        System.out.println("      PUSH (filling stack):        POP (emptying stack):");
        System.out.println("      ┌─────┐                      ┌─────┐");
        
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() / 2 || i == 0) {
                System.out.printf("      │  %c  │  ← pushing '%c'    ", str.charAt(i), str.charAt(i));
            } else {
                System.out.print("                           ");
            }
            
            if (i < str.length()) {
                System.out.printf("│  %c  │  → popping '%c'", 
                                str.charAt(str.length()-1-i), str.charAt(str.length()-1-i));
            }
            System.out.println();
        }
        
        System.out.println("      └─────┘                      └─────┘");
        System.out.println("      (TOP at top of stack)        (LIFO order)");
    }
    
    /**
     * Demonstrates stack operations in detail with a visual example
     * 
     * @param example the example string to demonstrate with
     */
    private static void demonstrateStackOperations(String example) {
        System.out.println("\n🔬 STACK OPERATIONS TUTORIAL:");
        System.out.println("   Example string: \"" + example + "\"");
        
        Stack<Character> demoStack = new Stack<>();
        String cleanExample = example.toLowerCase();
        
        System.out.println("\n   Step 1: Creating empty stack");
        System.out.println("   Stack: " + demoStack);
        System.out.println("   Empty? " + demoStack.isEmpty());
        
        System.out.println("\n   Step 2: PUSH operations (adding elements)");
        for (int i = 0; i < cleanExample.length(); i++) {
            char c = cleanExample.charAt(i);
            demoStack.push(c);
            System.out.printf("   push('%c') → Stack: %-20s (Top: '%c')%n", 
                            c, demoStack, demoStack.peek());
        }
        
        System.out.println("\n   Step 3: Stack after all pushes");
        System.out.println("   Full stack: " + demoStack);
        System.out.println("   Stack size: " + demoStack.size());
        System.out.println("   Top element (peek): '" + demoStack.peek() + "'");
        
        System.out.println("\n   Step 4: POP operations (removing elements)");
        System.out.println("   LIFO order - last in, first out:");
        while (!demoStack.isEmpty()) {
            char popped = demoStack.pop();
            System.out.printf("   pop() → '%c' | Stack now: %-20s %s%n", 
                            popped, demoStack, 
                            demoStack.isEmpty() ? "(empty)" : "(Top: '" + 
                            (demoStack.isEmpty() ? "none" : demoStack.peek()) + "')");
        }
    }
    
    /**
     * Compares different palindrome checking approaches
     * 
     * @param testString the string to test
     */
    private static void compareApproaches(String testString) {
        String cleanInput = testString.replaceAll("\\s+", "").toLowerCase();
        
        // Approach 1: String reversal
        long startTime = System.nanoTime();
        String reversed = new StringBuilder(cleanInput).reverse().toString();
        boolean approach1Result = cleanInput.equals(reversed);
        long approach1Time = System.nanoTime() - startTime;
        
        // Approach 2: Two-pointer with char[]
        startTime = System.nanoTime();
        char[] chars = cleanInput.toCharArray();
        boolean approach2Result = checkWithTwoPointersQuick(chars);
        long approach2Time = System.nanoTime() - startTime;
        
        // Approach 3: Stack-based
        startTime = System.nanoTime();
        boolean approach3Result = checkWithStackQuick(cleanInput);
        long approach3Time = System.nanoTime() - startTime;
        
        System.out.println("\n   📊 Performance Comparison for: \"" + testString + "\"");
        System.out.println("   ┌─────────────────────┬──────────────┬─────────────┐");
        System.out.println("   │ Method              │ Time (ns)    │ Result      │");
        System.out.println("   ├─────────────────────┼──────────────┼─────────────┤");
        System.out.printf("   │ %-19s │ %12d │ %-11s │%n", 
                         "String Reversal", approach1Time, approach1Result ? "✓" : "✗");
        System.out.printf("   │ %-19s │ %12d │ %-11s │%n", 
                         "Two-Pointer", approach2Time, approach2Result ? "✓" : "✗");
        System.out.printf("   │ %-19s │ %12d │ %-11s │%n", 
                         "Stack (LIFO)", approach3Time, approach3Result ? "✓" : "✗");
        System.out.println("   └─────────────────────┴──────────────┴─────────────┘");
        
        System.out.println("\n   📌 Note: Stack approach creates additional objects but");
        System.out.println("          clearly demonstrates LIFO principle and reversal.");
    }
    
    /**
     * Quick version of stack check for performance comparison
     */
    private static boolean checkWithStackQuick(String str) {
        Stack<Character> stack = new Stack<>();
        
        // Push all characters
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        // Pop and compare
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Quick version of two-pointer check for performance comparison
     */
    private static boolean checkWithTwoPointersQuick(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Formats a stack for display
     */
    private static String formatStack(Stack<Character> stack) {
        if (stack.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            if (i < stack.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Formats a stack showing the top element
     */
    private static String formatStackWithTop(Stack<Character> stack) {
        if (stack.isEmpty()) return "[empty]";
        StringBuilder sb = new StringBuilder();
        sb.append("Bottom → ");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            if (i < stack.size() - 1) {
                sb.append(" → ");
            }
        }
        sb.append(" ← Top");
        return sb.toString();
    }
}
