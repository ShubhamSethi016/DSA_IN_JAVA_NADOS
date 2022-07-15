import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

   public static class Pair implements Comparable<Pair> {
      int li; // list index;
      int di; // data index at which iteration will be done in each ith(li) list;
      int val; // value kept at each li(list) at di(at that list index);

      Pair(int li, int di, int val){
         this.li = li;
         this.di = di;
         this.val = val;
      }

      // compare function implemented by Comparable interface;
      // comparison will be done on val variable;
      // if this.val>other.val = return +ve;
      // else if this.val<other.val = return -ve;
      // else if this.val == other.val = return 0;
      public int compareTo(Pair o){
         return this.val - o.val;
      }
   }


   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here

      PriorityQueue<Pair> pq = new PriorityQueue<>();

    // addition of each list 0th index value in PQ;
      for(int i=0;i<lists.size();i++){
         Pair p = new Pair(i, 0, lists.get(i).get(0));
         pq.add(p);
      }


      while(pq.size()>0){
         Pair top = pq.remove(); // removal will be done on the basis of val in compareTo() based on smaller value;
         rv.add(top.val);
         top.di++; // data index is incremented by 1 in that list whose value is removed from it;


        // if data index(di) is less than that of that list(li) size => 
         if(top.di< lists.get(top.li).size()){
            // updating val at that li at that increased di index and then adding that updated object(li, di, val) into PQ;
            top.val = lists.get(top.li).get(top.di);
            pq.add(top);
         }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}

// TC = O(NlogN);
// SC = O(ans.size());