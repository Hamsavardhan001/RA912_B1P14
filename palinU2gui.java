/**
 * PalindromeChecker Application
 * This application checks if a given string is a palindrome
 */
public class palinU2gui {
    
    // Application constants
    private static final String APP_NAME = "Palindrome Checker";
    private static final String APP_VERSION = "1.0.0";
    private static final String APP_DESCRIPTION = "A simple application to check if a word or phrase reads the same forwards and backwards";
    
    /**
     * Main method - Entry point of the application
     * Displays welcome information and initializes the palindrome checker
     * 
     * @param args command line arguments (not used in this version)
     */
    public static void main(String[] args) {
        // Display application information
        displayWelcomeMessage();
        
        // The program will continue to the next use case here
        // For now, we'll just show that the application is ready
        System.out.println("\n" + APP_NAME + " is ready to check palindromes!");
        System.out.println("Program execution continues...");
        
        // Note: In a complete implementation, we would call a method here
        // to handle the palindrome checking functionality
        // processPalindromeInput();
    }
    
    /**
     * Displays the welcome message and application information
     */
    private static void displayWelcomeMessage() {
        // Print a decorative header
        System.out.println("=".repeat(60));
        System.out.println("            WELCOME TO THE " + APP_NAME.toUpperCase());
        System.out.println("=".repeat(60));
        
        // Display application information
        System.out.println("Application: " + APP_NAME);
        System.out.println("Version: " + APP_VERSION);
        System.out.println("Description: " + APP_DESCRIPTION);
        
        // Display current time and system information (optional)
        System.out.println("\nStarted at: " + new java.util.Date());
        System.out.println("Java Version: " + System.getProperty("java.version"));
        
        // Print a separator line
        System.out.println("-".repeat(60));
    }
}