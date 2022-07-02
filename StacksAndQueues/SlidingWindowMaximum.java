import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SlidingWindowMaximum{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code

    int[] prefixMax = new int[n];
    int[] suffixMax = new int[n];

    for(int i=0;i<n;i++){
       if(i%k == 0){
          prefixMax[i] = a[i];
       }else{
          prefixMax[i] = Math.max(prefixMax[i-1], a[i]);
       }
    }

    for(int i=n-2;i>=0;i--){
       if((i+1) % k == 0){
          suffixMax[i] = a[i];
       }else{
          suffixMax[i] = Math.max(suffixMax[i+1], a[i]);
       }
    }

    int[] ans = new int[n-k+1];

    for(int i=0;i<n-k+1;i++){
       ans[i] = Math.max(suffixMax[i], prefixMax[i+k-1]);
       System.out.println(ans[i]);
    }


 }
}

// TC = O(N);
// SC = O(2*N) ~= O(N);