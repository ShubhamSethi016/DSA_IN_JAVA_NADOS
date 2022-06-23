import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortKSortedArray {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int i=0;i<n;i++){
         if(i<=k){
            pq.add(arr[i]);
         }else{
            System.out.println(pq.remove());
            pq.add(arr[i]);
         }
      }

      while(pq.size()>0){
         System.out.println(pq.remove());
      }
   }

}

// TC = O(NlogK)
// SC = O(K) where K = size of pq used.