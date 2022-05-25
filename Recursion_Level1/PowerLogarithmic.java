import java.util.Scanner;

public class PowerLogarithmic {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n =scn.nextInt();
        int ans = power(x,n);
        System.out.println(ans);
        scn.close();
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }

        int xb2 = power(x,n/2);
        int ans = xb2*xb2;
        if(n%2 == 1){
            ans = ans*x;
        }

        return ans;
    }

}

// TC = O(logN)
// SC = O(1)