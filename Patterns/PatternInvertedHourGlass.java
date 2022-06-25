import java.util.Scanner;

public class PatternInvertedHourGlass{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nst = n;
    int nsp = 0;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=nsp;j++){
            System.out.print("\t");
        }

        for(int j=1;j<=nst;j++){
            if(i<n && i>n/2 && j>1 && j<nst){
                System.out.print("\t");
            }else{
                System.out.print("*\t");
            }
        }

        if(i<=n/2){
            nsp++;
            nst = nst-2;
        }else{
            nsp--;
            nst = nst+2;
        }
        System.out.println();
        scn.close();
    }
 }

}

// TC = O(N^2);
// SC = O(1);