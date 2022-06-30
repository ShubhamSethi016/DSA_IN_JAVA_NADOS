import java.util.Scanner;

public class PivotInSortedRotatedArray {

  public static int findPivot(int[] arr) {
    // write your code here
    int low = 0;
    int high = arr.length-1;

    while(low<high){
      int mid = low + (high-low)/2;

      if(arr[mid] < arr[high]){
        high = mid;
      }else if(arr[mid] > arr[high]){
        low = mid+1;
      } 
    }

    return arr[high];
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = findPivot(arr);
    System.out.println(pivot);
    scn.close();
  }

}

// TC = O(logN);
// SC = O(1);