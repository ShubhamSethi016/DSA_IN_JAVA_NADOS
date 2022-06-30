import java.util.Scanner;

public class SortDates {

  public static void sortDates(String[] arr) {
    // write your code here

    // range for days = 32 is passed as dates can be from 1-31 both inclusive hence 32 is passed.
    // Same for month as well as year range is passed.
    countSort(arr, 1000000, 100, 32); // days

    countSort(arr, 10000, 100, 13); // month

    countSort(arr, 1, 10000, 2501); // year
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    String[] ans = new String[arr.length];

    // freq array of each value =>
    int[] freqArr = new int[range];
    for(int i=0;i<arr.length;i++){
        int val = Integer.parseInt(arr[i], 10); // 10 is passed to convert passed arr[i] val into decimal value.
        // as for 07 => this will be taken as octal(bcz starting digit is 0) so will be considered as octal.
        // so to convert into decimal 10 is passed.
        val = (val/div) % mod;
        freqArr[val]++;
    }

    // prefixSum array =>
    for(int i=1;i<freqArr.length;i++){
      freqArr[i] += freqArr[i-1];
    }

    for(int i=arr.length-1;i>=0;i--){
      int val = Integer.parseInt(arr[i], 10);
      val = (val/div) % mod;
      int pos = freqArr[val];
      int idx = pos-1;
      ans[idx] = arr[i];
      freqArr[val]--;
    }

    for(int i=0;i<arr.length;i++){
      arr[i] = ans[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
    scn.close();
  }

}

// TC = O((N+K)*range); where O(N+K) is for countSort and range is for freqArr.
// SC = O(N+K);