import java.util.*;

public class Pattern14 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int x = scn.nextInt();

        for(int i=1;i<=10;i++){
              System.out.println(x + " * " + i + " = " + x*i);
        }
      scn.close();
    }
}

// Time Complexity = O(1) = constant as loop always runs 10 times for a single variable.
// Space Complexity = O(1)