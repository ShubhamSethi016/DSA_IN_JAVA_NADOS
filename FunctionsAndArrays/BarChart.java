// import java.io.*;
import java.util.*;

public class BarChart{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }

    int max = Integer.MIN_VALUE;

    for(int i=0;i<n;i++){
        if(arr[i]>max){
            max = arr[i];
        }
    }

    for(int i=max;i>=1;i--){
        for(int j=0;j<n;j++){
            if(arr[j]>=i){
                System.out.print("*\t");
            }else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }

    scn.close();
 }

}

// TC = O(N*N)
// SC = O(n) As a 1D array is used, therefore space complexity is linear.