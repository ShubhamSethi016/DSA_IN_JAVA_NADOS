import java.util.Scanner;

public class FirstAndLastIndex{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }
    int d = scn.nextInt();

    int firstIdx = -1;
    int lastIdx = -1;

    int low = 0;
    int high = n-1;

    // for First Index
    while(low<=high){
        int mid = low + (high-low)/2;
        if(d>arr[mid]){
            low = mid+1;
        }else if(d<arr[mid]){
            high = mid-1;
        }else{
            firstIdx = mid;
            high = mid-1;
        }
    }

    System.out.println(firstIdx);

    // for Last Index

    low = 0;
    high = n-1;
    while(low<=high){
        int mid = low + (high-low)/2;
        if(d>arr[mid]){
            low = mid+1;
        }else if(d<arr[mid]){
            high = mid-1;
        }else{
            lastIdx = mid;
            low = mid+1;
        }
    }
    System.out.println(lastIdx);

    scn.close();
 }

}

// TC = O(logN)
// SC = O(1)