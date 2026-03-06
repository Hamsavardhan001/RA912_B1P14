/**
 * PalindromeChecker Application
 * This application checks if a hardcoded string is a palindrome
 */
public class palinU1 {
    
    // Application constants
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.0.0";
    
    /**
     * Main method - Entry point of the application
     * Checks if a hardcoded string is a palindrome and displays the result
     * 
     * @param args command line arguments (not used in this version)
     */
    public static void main(String[] args) {
        // Display welcome message
        displayWelcomeMessage();
        
        // Hardcoded string to check (stored in String constant pool)
        String testString = "madam";  // Try changing this to "racecar", "hello", etc.
        
        // Check if the string is a palindrome
        boolean isPalindrome = checkPalindrome(testString);
        
        // Display the result
        displayResult(testString, isPalindrome);
        
        // Program exits after displaying the result
        System.out.println("\n" + APP_NAME + " execution completed. Exiting...");
    }
    
    /**
     * Displays the welcome message and application information
     */
    private static void displayWelcomeMessage() {
        System.out.println("=".repeat(50));
        System.out.println("     WELCOME TO THE " + APP_NAME.toUpperCase());
        System.out.println("=".repeat(50));
        System.out.println("Version: " + APP_VERSION);
        System.out.println("-".repeat(50));
    }
    
    /**
     * Checks if a given string is a palindrome
     * A palindrome reads the same forwards and backwards
     * 
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    private static boolean checkPalindrome(String str) {
        // Remove any spaces and convert to lowercase for better comparison
        // Note: For hardcoded strings without spaces, this is optional
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = cleanStr.length() - 1;
        
        // Compare characters from both ends moving towards the center
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;  // Characters don't match, not a palindrome
            }
            left++;
            right--;
        }
        
        return true;  // All characters matched, it's a palindrome
    }
    
    /**
     * Displays the result of the palindrome check
     * 
     * @param str the original string that was checked
     * @param isPalindrome true if the string is a palindrome, false otherwise
     */
    private static void displayResult(String str, boolean isPalindrome) {
        System.out.println("\n🔍 PALINDROME CHECK RESULT:");
        System.out.println("   String checked: \"" + str + "\"");
        System.out.println("   Length: " + str.length() + " characters");
        
        // Display each character for educational purposes
        System.out.print("   Characters: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print("'" + str.charAt(i) + "'");
            if (i < str.length() - 1) {
                System.out.print(" → ");
            }
        }
        System.out.println();
        
        // Display the result using if-else conditional statement
        if (isPalindrome) {
            System.out.println("   ✅ RESULT: \"" + str + "\" IS a palindrome!");
            System.out.println("      Reads the same forwards and backwards!");
        } else {
            System.out.println("   ❌ RESULT: \"" + str + "\" is NOT a palindrome.");
            System.out.println("      Does not read the same forwards and backwards.");
        }
    }
}
