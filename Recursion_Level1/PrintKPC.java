import java.util.Scanner;

public class PrintKPC {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str,"");
        scn.close();
    }
    static String[] list = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printKPC(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        String strOfChar = list[ch - '0'];
        for(int i=0;i<strOfChar.length();i++){
            String s = strOfChar.charAt(i) + "";
            printKPC(ros, asf + s);
        }


    }

}

// TC = O(2^N)
// SC = O(1)