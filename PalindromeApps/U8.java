import java.util.*;

public class U8{
    public static void main(String[] args){
        String str = "malayalam";
        LinkedList<Character> ll = new LinkedList();
        for(char c : str.toCharArray())ll.addFirst(c);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ll.get(i)){
                System.out.println("Not palindrome");
                break;
            }
            if (i == str.length() - 1)
                System.out.println("Palindrome");
        }
    }
}