import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();

        int ans = lastIndex(arr,n-1,x);
        System.out.println(ans);
        scn.close();

    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == -1){
            return -1;
        }

        if(arr[idx] == x){
            return idx;
        }
        
        int ans = lastIndex(arr,idx-1,x);

        return ans;
    }

}

// TC = O(N)
// SC = O(1)