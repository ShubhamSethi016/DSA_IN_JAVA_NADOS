import java.util.ArrayList;
import java.util.Scanner;

public class GetStairsPath {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> ans = getStairPaths(n);
        System.out.println(ans);
        scn.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n<0){
            return new ArrayList<>();
        }

        if(n == 0){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        ArrayList<String> ans = new ArrayList<>();

        ArrayList<String> step1 = getStairPaths(n-1);
        for(String s: step1){
            ans.add(1 + s);
        }
        ArrayList<String> step2 = getStairPaths(n-2);
        for(String s: step2){
            ans.add(2 + s);
        }
        ArrayList<String> step3 = getStairPaths(n-3);
        for(String s: step3){
            ans.add(3 + s);
        }

        return ans;
    }
}

// TC = O(3^N) as 3 recursive calls are made.
// SC = O(1)