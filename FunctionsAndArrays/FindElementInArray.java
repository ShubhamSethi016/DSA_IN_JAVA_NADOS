// import java.io.*;
import java.util.*;

public class FindElementInArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }

    int d = scn.nextInt();

    int idx = -1;
    for(int i=0;i<n;i++){
        if(arr[i] == d){
            idx=i;
            break;
        }
    }

    System.out.println(idx);
    scn.close();

    
 }

}

// TC = O(N)
// SC = O(1)