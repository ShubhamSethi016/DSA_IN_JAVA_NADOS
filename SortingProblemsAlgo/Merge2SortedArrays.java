import java.util.Scanner;

public class Merge2SortedArrays {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here
    int l1 = a.length;
    int l2 = b.length;
    int[] ans = new int[l1+l2];
    
    int i=0;
    int j=0;
    int k=0;
    while(i<l1 && j<l2){
      if(a[i]<b[j]){
        ans[k] = a[i];
        i++;
        k++;
      }else{
        ans[k] = b[j];
        j++;
        k++;
      }
    }

    while(i<l1){
      ans[k] = a[i];
      i++;
      k++;
    }

    while(j<l2){
      ans[k] = b[j];
      j++;
      k++;
    }

    return ans;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
    scn.close();
  }

}

// TC = O(n) where n = a.length + b.length
// SC = O(n) where n = a.length + b.length for ans array