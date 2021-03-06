import java.util.*;

public class Pattern17 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nsp = n/2;
        int nst = 1;
        for(int i=1;i<=n;i++){

            for(int j=1;j<=nsp;j++){
                if(i==n/2 + 1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }

            for(int j=1;j<=nst;j++){
                System.out.print("*\t");
            }

            if(i<=n/2){
                nst++;
            }else{
                nst--;
            }
            System.out.println();
        }

        scn.close();
    }
}

// TC = O(N)
// SC = O(1)