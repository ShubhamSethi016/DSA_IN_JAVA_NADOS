import java.util.Scanner;

public class CeilAndFloor{

public static void main(String[] args) throws Exception {
    try (// write your code here
    Scanner scn = new Scanner(System.in)) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();

        int ceil = -1;
        int floor = -1;

        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(d>arr[mid]){
                low = mid+1;
                floor = arr[mid];
            }else if(d<arr[mid]){
                high = mid-1;
                ceil = arr[mid];
            }else if(d==arr[mid]){
                System.out.println(ceil);
                System.out.println(floor);
                return;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);

        scn.close();
    }
 }

}

// TC = O(logn)
// SC = O(1)