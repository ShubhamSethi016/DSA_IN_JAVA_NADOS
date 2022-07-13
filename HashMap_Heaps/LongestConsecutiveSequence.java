import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = scn.nextInt();
    }

    HashMap<Integer, Boolean> map = new HashMap<>();

    // 1st iteration => putting all the elements as true into map;
    for(int val: arr){
        map.put(val, true);
    }

    // 2nd iteration => checking for the starting element of the sequence i,e;
    // if for any element its (element-1) value is present in map, then that element cannot be the starting point of that sequence;
    // then make that element as false in map;
    for(int val: arr){
        if(map.containsKey(val-1)){
            map.put(val, false);
        }
    }

    int msp = 0; // maxStartingPoint of the sequence
    int ml = 0; // maxLength
    // 3rd iteration => traversing through only true elements in map =>
    // and finding if for any element its (element+1) value is present then that can be our sequence;
    // hence to find the max sequence while loop is applied and checked the max sequence;
    for(int val: arr){
        if(map.get(val) == true){
            int tl = 1; // temporary length
            int tsp = val; // temporary starting point = val which is marked true;
            while(map.containsKey(tsp + tl)){
                tl++;
            }

            if(tl> ml){
                ml = tl;
                msp = tsp;
            }
        }
    }

    // 4th iteration => for printing the final max sequence we got;
    for(int i=0;i<ml;i++){
        System.out.println(msp + i);
    }

    scn.close();
 }

}

// TC = O(N);
// SC = O(N);
