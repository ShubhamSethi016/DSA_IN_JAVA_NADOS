import java.util.Scanner;

public class CountSort {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   // STEP 1&2 =>
   int range = max - min + 1;
   int[] freqArr = new int[range];

    // STEP 3 =>
   for(int i=0;i<arr.length;i++){
     int idx = arr[i] - min;
      freqArr[idx]++;
   }

  // STEP 4 =>
  for(int i=1;i<freqArr.length;i++){
    freqArr[i] = freqArr[i] + freqArr[i-1];
  }

  // STEP 5 =>
  int[] ans = new int[arr.length];
  for(int i=arr.length-1;i>=0;i--){
    int val = arr[i];
    int pos = freqArr[val - min];
    int idx = pos-1;
    ans[idx] = val;
    freqArr[val-min]--;
  }

  for(int i=0;i<arr.length;i++){
    arr[i] = ans[i];
  }

   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
    scn.close();
  }

}

// TC = O(N + K); where N = given arr length && K = freqArr length;
// SC = O(N + K);