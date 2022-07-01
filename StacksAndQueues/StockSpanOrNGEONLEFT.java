import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpanOrNGEONLEFT{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve

    int n = arr.length;
    int[] span = new int[n];
    span[0] = 1;
    Stack<Integer> st = new Stack<>();
    st.push(0);

    for(int i=1;i<n;i++){
      while(st.size()>0 && arr[i]>arr[st.peek()]){
        st.pop();
      }

      if(st.size() == 0){
        span[i] = i+1;
      }else{
        span[i] = i-st.peek();
      }

      st.push(i);
    }

    return span;
 }
}

// TC = O(N);
// SC = O(N);