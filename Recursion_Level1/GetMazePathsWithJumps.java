import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsWithJumps {

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

        ArrayList<String> ans = new ArrayList<>();

        for(int i=1;i<=dc-sc;i++){
            ArrayList<String> hPaths = getMazePaths(sr,sc+i,dr,dc);

            for(String str: hPaths){
                ans.add("h" + i + str);
            }
        }

        for(int i=1;i<=dr-sr;i++){
            ArrayList<String> vPaths = getMazePaths(sr+i,sc,dr,dc);
            for(String str: vPaths){
                ans.add("v" + i + str);
            }
        }

        for(int i=1;i<=dc-sc && i<=dr-sr;i++){
            ArrayList<String> dPaths = getMazePaths(sr+i,sc+i,dr,dc);
            for(String str: dPaths){
                ans.add("d" + i + str);
            }
        }        
         
        return ans;
    }

}

// TC = O(3^(N+M))
// SC = O(1)