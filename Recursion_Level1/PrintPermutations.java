import java.util.Scanner;

public class PrintPermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str,"");
        scn.close();
    }

    public static void printPermutations(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i=0;i<str.length();i++){
            String ch = str.charAt(i) + "";
            String leftPart = str.substring(0,i);
            String rightPart = str.substring(i+1);
            String restOfString = leftPart+rightPart;
            printPermutations(restOfString,asf+ch);
        }
    }

}

// TC = O(n!)
// SC = O(1)