import java.util.*;
import java.util.Scanner;

public class PrintDecreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
        scn.close();
    }

    public static void printDecreasing(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
}

// TC = O(N)
// SC = O(1) but taking into recursive call stack the space used by it is O(N) but generally we ignore the space used by stack(recursive) HENCE O(1) 