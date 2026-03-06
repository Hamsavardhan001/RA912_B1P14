/**
 * PalindromeChecker Application
 * This application checks if a string is a palindrome by reversing it
 */
public class palinU3 {
    
    // Application constants
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.1.0";
    
    /**
     * Main method - Entry point of the application
     * Demonstrates palindrome checking using string reversal
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
            "A man a plan a canal Panama"  // Phrase with spaces
        };
        
        // Test each string
        for (String testString : testStrings) {
            System.out.println("\n" + "=".repeat(50));
            checkPalindromeByReversal(testString);
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println(APP_NAME + " execution completed. Exiting...");
    }
    
    /**
     * Displays the welcome message and application information
     */
    private static void displayWelcomeMessage() {
        System.out.println("=".repeat(60));
        System.out.println("     WELCOME TO THE " + APP_NAME.toUpperCase());
        System.out.println("=".repeat(60));
        System.out.println("Version: " + APP_VERSION);
        System.out.println("Method: Checking palindrome by reversing the string");
        System.out.println("-".repeat(60));
    }
    
    /**
     * Checks if a string is a palindrome by reversing it using a loop
     * Demonstrates string immutability and concatenation
     * 
     * @param input the string to check
     */
    private static void checkPalindromeByReversal(String input) {
        System.out.println("\n🔍 ANALYZING: \"" + input + "\"");
        
        // Step 1: Clean the string (remove spaces and convert to lowercase for comparison)
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        System.out.println("   Cleaned version: \"" + cleanInput + "\"");
        
        // Step 2: Reverse the string using a for loop
        // NOTE: Due to String immutability, each concatenation creates a new String object
        String reversed = reverseString(cleanInput);
        
        // Step 3: Compare original (cleaned) with reversed using equals() method
        boolean isPalindrome = cleanInput.equals(reversed);
        
        // Step 4: Display detailed results
        displayDetailedResult(input, cleanInput, reversed, isPalindrome);
    }
    
    /**
     * Reverses a string using a for loop
     * Demonstrates:
     * - For loop iteration
     * - String immutability
     * - String concatenation
     * 
     * @param str the string to reverse
     * @return the reversed string
     */
    private static String reverseString(String str) {
        // Start with an empty string
        String reversed = "";
        
        System.out.println("   🔄 Reversal process:");
        System.out.print("      Original: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
        
        System.out.print("      Reversed: ");
        // Loop through the string from the last character to the first
        for (int i = str.length() - 1; i >= 0; i--) {
            // Get character at current position
            char currentChar = str.charAt(i);
            
            // String concatenation - creates a NEW String object each time!
            // This demonstrates String immutability
            reversed = reversed + currentChar;
            
            // Show the building process
            System.out.print(currentChar + " ");
        }
        System.out.println();
        
        System.out.println("   📊 Final reversed string: \"" + reversed + "\"");
        
        return reversed;
    }
    
    /**
     * Displays detailed comparison results
     * Shows the difference between == and equals() for String comparison
     * 
     * @param original the original input string
     * @param cleaned the cleaned version of the string
     * @param reversed the reversed string
     * @param isPalindrome whether it's a palindrome
     */
    private static void displayDetailedResult(String original, String cleaned, 
                                            String reversed, boolean isPalindrome) {
        System.out.println("\n   📋 COMPARISON RESULTS:");
        
        // Show string contents
        System.out.println("      Original (cleaned): \"" + cleaned + "\"");
        System.out.println("      Reversed: \"" + reversed + "\"");
        
        // Demonstrate == vs equals() for String comparison
        System.out.println("\n   🔬 String Comparison Demo:");
        System.out.println("      Using == operator: " + (cleaned == reversed) + 
                         " (compares references, not content)");
        System.out.println("      Using equals() method: " + cleaned.equals(reversed) + 
                         " (compares actual content)");
        
        // Visual representation of the reversal
        System.out.println("\n   🔄 Visual check:");
        System.out.print("      Forward:  ");
        for (int i = 0; i < cleaned.length(); i++) {
            System.out.print(cleaned.charAt(i) + " ");
        }
        System.out.println();
        
        System.out.print("      Backward: ");
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            System.out.print(cleaned.charAt(i) + " ");
        }
        System.out.println();
        
        // Final verdict with if-else
        System.out.print("   ⚖️ VERDICT: ");
        if (isPalindrome) {
            System.out.println("✅ \"" + original + "\" IS a palindrome!");
            if (!original.equals(cleaned)) {
                System.out.println("      (After ignoring spaces and case)");
            }
        } else {
            System.out.println("❌ \"" + original + "\" is NOT a palindrome.");
        }
    }
}
