import java.util.*;

public class FirstIndex {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();

        int ans = firstIndex(arr,0,x);
        System.out.println(ans);
        scn.close();
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == x){
            return idx;
        }

        int ans = firstIndex(arr,idx+1,x);
        return ans;
    }

}

// TC = O(N)
// SC = O(1)