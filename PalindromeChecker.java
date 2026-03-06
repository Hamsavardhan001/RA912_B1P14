/**
 * PalindromeChecker Application
 * This application checks if a string is a palindrome using character arrays and two-pointer technique
 */
public class PalindromeChecker {
    
    // Application constants
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.2.0";
    
    /**
     * Main method - Entry point of the application
     * Demonstrates palindrome checking using char[] and two-pointer technique
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
            "A man a plan a canal Panama",  // Phrase with spaces
            "12321",                         // Numeric palindrome
            "Was it a car or a cat I saw"    // Another phrase
        };
        
        // Test each string using the efficient two-pointer approach
        for (String testString : testStrings) {
            System.out.println("\n" + "═".repeat(60));
            checkPalindromeWithCharArrays(testString);
        }
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📊 PERFORMANCE COMPARISON:");
        compareApproaches("madam");
        compareApproaches("A man a plan a canal Panama");
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println(APP_NAME + " execution completed. Exiting...");
    }
    
    /**
     * Displays the welcome message and application information
     */
    private static void displayWelcomeMessage() {
        System.out.println("═".repeat(70));
        System.out.println("     WELCOME TO THE " + APP_NAME.toUpperCase());
        System.out.println("═".repeat(70));
        System.out.println("Version: " + APP_VERSION);
        System.out.println("Method: Character Array with Two-Pointer Technique");
        System.out.println("⭐ Key Benefits: Memory efficient, Early termination, O(n) time complexity");
        System.out.println("─".repeat(70));
    }
    
    /**
     * Checks if a string is a palindrome using character array and two-pointer technique
     * This approach is more memory efficient as it doesn't create additional string objects
     * 
     * @param input the string to check
     */
    private static void checkPalindromeWithCharArrays(String input) {
        System.out.println("\n🔍 ANALYZING: \"" + input + "\"");
        
        // Step 1: Clean the string (remove spaces and convert to lowercase)
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        System.out.println("   📝 Cleaned version: \"" + cleanInput + "\"");
        
        // Step 2: Convert string to character array
        // This creates a char[] containing each character of the string
        char[] characters = cleanInput.toCharArray();
        System.out.println("   📦 Converted to char[] with length: " + characters.length);
        
        // Display the character array
        System.out.print("      Character array: [");
        for (int i = 0; i < characters.length; i++) {
            System.out.print("'" + characters[i] + "'");
            if (i < characters.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Step 3: Use two-pointer technique to check if it's a palindrome
        boolean isPalindrome = checkWithTwoPointers(characters);
        
        // Step 4: Display detailed results
        displayDetailedResult(input, cleanInput, characters, isPalindrome);
    }
    
    /**
     * Implements the two-pointer technique on a character array
     * Time Complexity: O(n/2) = O(n) - only need to check half the array
     * Space Complexity: O(1) - no additional data structures created
     * 
     * @param chars the character array to check
     * @return true if the array represents a palindrome
     */
    private static boolean checkWithTwoPointers(char[] chars) {
        System.out.println("\n   🎯 TWO-POINTER TECHNIQUE:");
        
        // Initialize two pointers
        int left = 0;                    // Points to the start (index 0)
        int right = chars.length - 1;     // Points to the end (last index)
        
        System.out.println("      Initial positions: left = " + left + " ('" + chars[left] + 
                          "'), right = " + right + " ('" + chars[right] + "')");
        System.out.println("      " + "⬇️".repeat(20));
        
        int comparisons = 0;
        int steps = 0;
        
        // Continue until pointers meet or cross
        while (left < right) {
            steps++;
            comparisons++;
            
            // Get characters at both pointers
            char leftChar = chars[left];
            char rightChar = chars[right];
            
            System.out.printf("      Step %d: Comparing '%c' (left[%d]) with '%c' (right[%d])%s",
                            steps, leftChar, left, rightChar, right, 
                            (leftChar == rightChar) ? " ✓" : " ✗");
            System.out.println();
            
            // Compare characters
            if (leftChar != rightChar) {
                System.out.println("      ❌ Mismatch found! Not a palindrome.");
                System.out.println("      Total comparisons made: " + comparisons);
                return false;  // Early termination - no need to check further
            }
            
            // Move pointers towards the center
            left++;
            right--;
            
            if (left < right) {
                System.out.println("         → Moving pointers: left now at " + left + 
                                 " ('" + chars[left] + "'), right now at " + right + 
                                 " ('" + chars[right] + "')");
            }
        }
        
        // If we get here, all characters matched
        System.out.println("      ✅ All " + comparisons + " character pairs matched!");
        if (chars.length % 2 == 0) {
            System.out.println("      (Even length string - all characters compared in pairs)");
        } else {
            System.out.println("      (Odd length string - middle character '" + chars[left] + 
                             "' doesn't need comparison)");
        }
        
        return true;
    }
    
    /**
     * Displays detailed comparison results showing the two-pointer process
     * 
     * @param original the original input string
     * @param cleaned the cleaned version of the string
     * @param chars the character array
     * @param isPalindrome whether it's a palindrome
     */
    private static void displayDetailedResult(String original, String cleaned, 
                                            char[] chars, boolean isPalindrome) {
        System.out.println("\n   📋 FINAL ANALYSIS:");
        
        // Show array indexing demonstration
        System.out.println("   🔢 Array Indexing Demo:");
        System.out.print("      Indices:  ");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-3d", i);
        }
        System.out.println();
        
        System.out.print("      Chars:    ");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("%-3c", chars[i]);
        }
        System.out.println();
        
        // Visual representation of two-pointer comparison
        System.out.println("\n   👆 Two-Pointer Visualization:");
        System.out.print("      ");
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length / 2) {
                System.out.print("⬅️ ");
            } else if (i > chars.length / 2) {
                System.out.print("➡️ ");
            } else if (chars.length % 2 == 1 && i == chars.length / 2) {
                System.out.print("⬇️ ");
            }
        }
        System.out.println();
        
        // Verdict
        System.out.print("\n   ⚖️ VERDICT: ");
        if (isPalindrome) {
            System.out.println("✅ \"" + original + "\" IS a palindrome!");
            if (!original.equals(cleaned)) {
                System.out.println("      (After removing spaces and ignoring case)");
            }
            System.out.println("      ✓ Character array comparison successful");
            System.out.println("      ✓ Two-pointer technique validated");
        } else {
            System.out.println("❌ \"" + original + "\" is NOT a palindrome.");
            System.out.println("      ✗ Character mismatch detected");
        }
    }
    
    /**
     * Compares different palindrome checking approaches
     * Demonstrates the efficiency of the two-pointer technique
     * 
     * @param testString the string to test
     */
    private static void compareApproaches(String testString) {
        System.out.println("\n   📊 Approach Comparison for: \"" + testString + "\"");
        
        String cleanInput = testString.replaceAll("\\s+", "").toLowerCase();
        
        // Approach 1: String reversal (creates new strings)
        long startTime = System.nanoTime();
        String reversed = new StringBuilder(cleanInput).reverse().toString();
        boolean approach1Result = cleanInput.equals(reversed);
        long approach1Time = System.nanoTime() - startTime;
        
        // Approach 2: Two-pointer with char[] (no extra objects)
        startTime = System.nanoTime();
        char[] chars = cleanInput.toCharArray();
        boolean approach2Result = checkWithTwoPointersQuick(chars);
        long approach2Time = System.nanoTime() - startTime;
        
        System.out.println("      Method 1 (String Reversal): " + approach1Time + " ns" +
                         (approach1Result ? " ✓" : " ✗"));
        System.out.println("      Method 2 (Two-Pointer):     " + approach2Time + " ns" +
                         (approach2Result ? " ✓" : " ✗"));
        
        if (approach2Time < approach1Time) {
            System.out.println("      ⚡ Two-pointer is " + 
                             String.format("%.2f", (double)approach1Time/approach2Time) + 
                             "x faster for this string");
        }
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
}