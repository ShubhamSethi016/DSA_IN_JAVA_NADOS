import java.util.*;

public class DigitsOfFrequency {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
        scn.close();
    }

    public static int getDigitFrequency(int n, int d) {
        // write code here
        int count = 0;
        while(n>0){
            int val = n%10;
            n = n/10;
            if(val == d){
                count++;
            }
        }

        return count;
    }
}


// TC = O(logN)
// SC = O(1)