import java.util.Scanner;

public class Pattern18{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     int nsp = 0;
     int nst = n;

     for(int i=1;i<=n;i++){

        for(int j=1;j<=nsp;j++){
            System.out.print("\t");
        }
        

        for(int j=1;j<=nst;j++){
            if(i>1 && i<=n/2 && j>1 && j<nst){
                System.out.print("\t");
            }else{
                System.out.print("*\t");
            }
        }
        
        if(i<=n/2){
            nsp++;
            nst = nst - 2;
        }else{
            nsp--;
            nst = nst + 2;
        }

        System.out.println();
     }
    scn.close();
 }
}

// TC = O(N^2);
// SC = O(1)