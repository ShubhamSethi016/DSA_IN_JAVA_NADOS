import java.util.Scanner;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printEncodings(str, "");
        scn.close();
    }

    public static void printEncodings(String str, String ans) {
         if(str.length() == 0){
             System.out.println(ans);
             return;
         }else if(str.length() == 1){
             char ch = str.charAt(0);
             if(ch == '0'){
                 return;
             }else{
                 int chv = ch - '0';
                 char code = (char)(chv + 'a' - 1);
                 System.out.println(ans + code);
                 return;
             }

         }else{ // if str.length() > 2 =>
            char ch = str.charAt(0);
            String ros = str.substring(1);

            if(ch == '0'){
                return;
            }else{
                int chv = ch - '0';
                char code = (char)(chv + 'a' - 1);
                printEncodings(ros, ans + code);
            }

            String ch12 = str.substring(0,2);
            String ros12 = str.substring(2);

            int chv12 = Integer.parseInt(ch12);
            if(chv12 <= 26){
                char code = (char)(chv12 + 'a' - 1);
                printEncodings(ros12, ans + code);
            }
         }
    }

}

// TC = O(2^N);
// SC = O(N) recursion stack space is taken into account.