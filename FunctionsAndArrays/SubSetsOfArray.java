import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubSetsOfArray{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    int count = (int)Math.pow(2,n);
    for(int i=0;i<count;i++){
       String ans = "";
       int temp = i;
       for(int j=n-1;j>=0;j--){
          int val = temp%2;
          temp = temp/2;
          if(val == 0){
             ans = "-\t" + ans;
          }else{
             ans = arr[j] + "\t" + ans;
          }
       }
       System.out.println(ans);
    }

    
 }

}

// TC = O((2^n)*n) as outer loop runs from 0 to 2^n(count) and inner loop run for n times hence O((2^n)*n).
// SC = O(n)