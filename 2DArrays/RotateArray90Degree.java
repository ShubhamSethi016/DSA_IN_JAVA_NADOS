import java.util.*;

public class RotateArray90Degree {

    public static void main(String[] args) throws Exception {
        // write your code here

        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[0].length; j++){
                    arr[i][j] = scn.nextInt();
                }
            }

            // TRANSPOSING
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }

            // REVERSING EACH ROW ELEMENTS WITHIN ITSELF
            for(int i=0;i<n;i++){
                int low = 0;
                int high = n-1;
                while(low<=high){
                    int temp = arr[i][low];
                    arr[i][low] = arr[i][high];
                    arr[i][high] = temp;
                    low++;
                    high--;
                }
            }

            display(arr);
        }

    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}


// TC = O(N^2)
// SC = O(1)