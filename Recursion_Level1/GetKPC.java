import java.util.ArrayList;
import java.util.Scanner;

public class GetKPC {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);
        scn.close();
    }

    static String[] list = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        char ch = str.charAt(0);
        ArrayList<String> restOfString = getKPC(str.substring(1));

        ArrayList<String> fans = new ArrayList<>();

        String code = list[ch - '0'];
        
        for(int i=0;i<code.length();i++){
            String c = code.charAt(i) + "";
            for(String s: restOfString){
                fans.add(c + s);
            }
        }

        return fans;
    }

}