// import java.io.*;
import java.util.*;

public class SpanOfArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for(int i=0;i<n;i++){
        if(arr[i]<min){
            min = arr[i];
        }

        if(arr[i]>max){
            max = arr[i];
        }
    }

    int ans = max-min;
    System.out.println(ans);

    scn.close();
 }

}

// TC = O(N)
// SC = O(1)