import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
 class KLargestElements
  {
 	 public static void main (String[] args) throws IOException
 	  {
 	 	 Scanner scn= new Scanner(System.in);
 	    	 int n = scn.nextInt();
 	 	 int[] num = new int[n];
 	 	 for (int i = 0; i < n; i++) {
 	 	 	 	 num[i] = scn.nextInt();
 	 	 	 }
 	 	 int k = scn.nextInt();
 	 	 solve(n,num,k);

         scn.close();
 	  }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input an array,n length of array and k.
 	 // It should print required output.
 	  public static void solve(int n,int[] arr,int k){
 	     //Write your code here
		  PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		  for(int i=0;i<n;i++){
			  pq.add(arr[i]);
		  }

		  while(k>0){
			  System.out.print(pq.peek() + " ");
			  pq.remove();
			  k--;
		  }

     }
 }

//  TC = O(NlogK)
// SC = O(K) where K = size of Priority Queue used.