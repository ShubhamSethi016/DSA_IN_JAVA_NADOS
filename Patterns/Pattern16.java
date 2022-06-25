import java.util.*;

public class Pattern16{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     int nst = 1;
     int nsp = 2*n - 3;

     for(int i=1;i<=n;i++){
         int val = 1;
         for(int j=1;j<=nst;j++){
             System.out.print(val + "\t");
             val++;
         }

         for(int j=1;j<=nsp;j++){
             System.out.print("\t");
         }

         if(i == n){
             nst--;
             val--;
         }

         for(int j=1;j<=nst;j++){
             val--;
             System.out.print(val + "\t");
         }

         nst++;
         nsp = nsp - 2;
         System.out.println();
     }

        scn.close();
 }
}

// TC = O(N^2);
// SC = O(1)