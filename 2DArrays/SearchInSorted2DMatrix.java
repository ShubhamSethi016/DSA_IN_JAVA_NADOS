import java.util.*;

public class SearchInSorted2DMatrix {

    public static void main(String[] args) throws Exception {
        try (// write your code here
    Scanner scn = new Scanner(System.in)) {
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
            arr[i][j] = scn.nextInt();
          }
        }
        int x = scn.nextInt();

        int i = 0;
        int j = n-1;
        
        while(i<n && j>=0){
            if(x>arr[i][j]){
                i++;
            }else if(x<arr[i][j]){
                j--;
            }else if(x == arr[i][j]){
                System.out.println(i);
                System.out.println(j);
                return;
            }
        }

        System.out.println("Not Found");
        scn.close();
    }
    }

}

// TC = O(m*n) to O(m+n).
//  O(m*n) is for linear traversal using 2 loops and searching at every index and then printing the output.
//  whereas for the above approch it is O(m+n) which is equal to O(n) as we are just iterating a single loop.

// SC = O(1)