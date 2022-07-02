import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code

    // RIGHT BOUNDARY(rb) =>
    int[] rb = new int[n]; // next smaller element on right (from right -> left)
    Stack<Integer> st = new Stack<>();
    rb[n-1] = n;
    st.push(n-1); // indexes

    for(int i=n-2;i>=0;i--){
       while(st.size() > 0 && arr[i]<=arr[st.peek()]){
          st.pop();
       }

       if(st.size() == 0){
          rb[i] = n;
       }else{
          rb[i] = st.peek();
       }

       st.push(i);
    }

    // LEFT BOUNDARY(lb) =>
    int[] lb = new int[n]; // // next smaller element on left (from left->right)
    st = new Stack<>();
    lb[0] = -1;
    st.push(0);

    for(int i=1;i<n;i++){
       while(st.size()>0 && arr[i]<=arr[st.peek()]){
          st.pop();
       }

       if(st.size() == 0){
          lb[i] = -1;
       }else{
          lb[i] = st.peek();
       }

       st.push(i);
    }

    // AREA =>

    int maxArea = 0;
    for(int i=0;i<n;i++){
       int width = rb[i] - lb[i] - 1;
       int area = arr[i] * width;
       if(area > maxArea){
          maxArea = area;
       }
    }

    System.out.println(maxArea);
 }
}

// TC = O(N);
// SC = O(N);