import java.util.*;

public class Pattern15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int nst = 1;
        int nsp = n/2;
        int rowVal = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=nsp;j++){
                System.out.print("\t");
            }
            
            int colVal = rowVal;
            for(int j=1;j<=nst;j++){
                System.out.print(colVal + "\t");

                if(j<=nst/2){
                    colVal++;
                }else{
                    colVal--;
                }
            }

            if(i<=n/2){
                rowVal++;
                nsp--;
                nst = nst+2;
            }else{
                rowVal--;
                nsp++;
                nst = nst-2;
            }
            System.out.println();
        }

        scn.close();
    }
}


// Time Complexity: O(n)

// Space Complexity: O(1)