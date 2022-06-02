import java.util.Scanner;

public class PrintSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSS(str, "");
        scn.close();
    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        
        char ch = str.charAt(0);
        String subString = str.substring(1);
        printSS(subString,ans + ch);
        printSS(subString,ans + "");      
    }

}

// TC = O(2^N)
// SC = O(1)