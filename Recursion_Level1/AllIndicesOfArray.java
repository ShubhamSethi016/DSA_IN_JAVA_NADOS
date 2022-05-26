import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AllIndicesOfArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println("NO OUTPUT");
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here
        if(idx == arr.length){
            int[] tempArr = new int[fsf];
            return tempArr;
        }
        if(arr[idx] == x){
            int[] ans = allIndices(arr,x,idx+1,fsf+1);
            ans[fsf] = idx;
            return ans;
        }else{
            int[] ans = allIndices(arr,x,idx+1,fsf);
            return ans;
        }
        // return ans;
    }
}

// TC = O(N)
// SC = O(fsf) which will be constant as we are only printing the values as well as no extra data structure is used.