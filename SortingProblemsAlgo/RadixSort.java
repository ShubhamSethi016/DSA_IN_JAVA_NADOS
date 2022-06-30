import java.util.Scanner;

public class RadixSort {

  public static void radixSort(int[] arr) {
    // write code here    

    int max = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
      int val = arr[i];
      if(val>max){
        max = val;
      }
    }

    int exp = 1;
    while(exp<=max){
      countSort(arr, exp);
      exp = exp * 10;
    }

  }

  public static void countSort(int[] arr, int exp) {
    // write code here

    int[] ans = new int[arr.length];

    // Range will be from 0-10 hence freqArr is of size 10;
    int[] freqArr = new int[10];

    // Making count array of each element based on exponent
    // (unit's place , ten's place , hundred's place and so on ONE AT A TIME);
    for(int i=0;i<arr.length;i++){
      int val = arr[i]/ exp % 10;
      freqArr[val]++;
    }

    // converting into prefixSum count arr
    for(int i=1;i<freqArr.length;i++){
      freqArr[i] += freqArr[i-1];
    }

    for(int i=arr.length-1;i>=0;i--){
      int val = arr[i]/exp % 10;
      int pos = freqArr[val];
      int idx = pos-1;
      ans[idx] = arr[i];
      freqArr[val]--;
    }

    for(int i=0;i<arr.length;i++){
      arr[i] = ans[i];
    }

    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);

  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
    scn.close();
  }

}


// TC = O(N+K) for CountSort where N = number of elements in given array && K = Size of FreqArr;
// But Here K = 10 is constant Hence overall TC for CountSort = O(N);

// TC for RadixSort = O(N*b) where b = maximum element size(while loop in RadixSort where exp is maintained);
// SC = O(N*b);