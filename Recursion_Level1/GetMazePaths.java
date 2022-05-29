import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        ArrayList<String> ans = getMazePaths(0,0,n-1,m-1);
        System.out.println(ans);
        scn.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr>dr || sc>dc){
            return new ArrayList<>();
        }
        
        if(sr == dr && sc == dc){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        ArrayList<String> hPaths = getMazePaths(sr,sc+1,dr,dc);
        
        ArrayList<String> vPaths = getMazePaths(sr+1,sc,dr,dc);

        
        ArrayList<String> ans = new ArrayList<>();
        
        for(String str: hPaths){
            ans.add("h" + str);
        }

        for(String str: vPaths){
            ans.add("v" + str);
        }

        return ans;
    }

}

// TC = O(2^N)
// SC = O(1)