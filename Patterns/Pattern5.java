import java.util.*;

public class Pattern5 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nsp = n/2;
        int nst = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print("\t");
            }

            for(int j=1;j<=nst;j++){
                System.out.print("*\t");
            }

            if(i<=n/2){
                nst = nst + 2;
                nsp--;
            }else{
                nst = nst - 2;
                nsp++;
            }
            System.out.println();
        }
        scn.close();
    }
}

// Time complexity = O(N) + O(N/2) + O(N) ~= O(N).
// O(N) - outer loop && O(N/2) - spaces && O(N) - stars
// Space complexity= O(1)