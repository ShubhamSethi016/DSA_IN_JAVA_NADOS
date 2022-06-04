import java.util.Scanner;

public class TargetSumSubsets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        
        printTargetSumSubsets(arr,0,"",target,target);
        scn.close();
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(sos<0){
            return;
        }

        if(idx == arr.length){
            if(sos == 0 && idx == arr.length+1){
                System.out.println(set + ".");
            }
            
            return;
        }
        
        printTargetSumSubsets(arr,idx+1,set+arr[idx],sos-arr[idx],tar); 
        printTargetSumSubsets(arr,idx+1,set,sos,tar);
       
    }

}