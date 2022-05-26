import java.util.Scanner;

public class MaxOfArrayUsingRecursion {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int ans = maxOfArray(arr,0);
        System.out.println(ans);
        scn.close();
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length){
            return Integer.MIN_VALUE;
        }

        int max = maxOfArray(arr,idx+1);
        
        if(arr[idx]>max){
            max = arr[idx];
        }
        return max;
    }
}

// TC = O(N)
// SC = O(1)