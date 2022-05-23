import java.util.*;

public class Pattern4 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nst = n;
        int nsp = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print("\t");
            }

            for(int j=1;j<=nst;j++){
                System.out.print("*\t");
            }

            nsp++;
            nst--;
            System.out.println();
        }
        scn.close();
    }
}


// Time Complexity 
// Here we are running one for loop to print no. of rows and in that for loop, we are doing total nsp + nst operations which is always n so our total time complexity will be : O(n^2).

// Space Complexity :
// We are not using any extra space so space complexity is constant O(1).