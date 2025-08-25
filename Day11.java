import java.util.*;

public class StringPermutations {
    
    // Recursive function to generate permutations
    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Remaining string after removing current char
            String ros = str.substring(0, i) + str.substring(i + 1);
            
            // Recursive call
            permute(ros, ans + ch);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("All permutations:");
        permute(str, "");
        
        sc.close();
    }
}
