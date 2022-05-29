import java.util.*;

public class GetSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = gss(str);
        System.out.print(ans);
        scn.close();
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        char ch = str.charAt(0);
        ArrayList<String> restOfString = gss(str.substring(1));

        ArrayList<String> ans = new ArrayList<>();

        for(String s: restOfString){
            ans.add(s + "");
        }

        for(String s: restOfString){
            ans.add(ch + s);
        }

        return ans;
    }

}

// TC = O(N)
// SC = O(1) but if we include recursive staack space then it will be O(N)