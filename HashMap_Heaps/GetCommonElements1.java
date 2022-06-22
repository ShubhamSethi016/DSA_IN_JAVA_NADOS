import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements1{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0;i<n1;i++){
        arr1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0;i<n2;i++){
        arr2[i] = scn.nextInt();
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<n1;i++){
        if(map.containsKey(arr1[i]) == true){
            int val = map.get(arr1[i]);
            val++;
            map.put(arr1[i], val);
        }else{
            map.put(arr1[i], 1);
        }
    }

    for(int i=0;i<n2;i++){
        int val = arr2[i];
        if(map.containsKey(val) == true){
            System.out.println(val);
            map.remove(val);
        }
    }

    scn.close();
 }

}

// TC = O(N)
// SC = O(N)
