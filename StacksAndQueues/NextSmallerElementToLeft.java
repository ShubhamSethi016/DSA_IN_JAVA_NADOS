import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextSmallerElementToLeft{
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

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   int n = arr.length;
   int[] nge = new int[n];
   Stack<Integer> st = new Stack<>();
   nge[0] = -1;
   st.push(0); // indexes

   for(int i=1;i<n;i++){
     while(st.size()>0 && arr[i]<=arr[st.peek()]){
       st.pop();
     }
     if(st.size() == 0){
       nge[i] = -1;
       st.push(i);
     }else {
       nge[i] = st.peek();
       st.push(i);
     }
    }

   return nge;

 }

}

// TC = O(N)
// SC = O(N)