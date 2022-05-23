import java.util.*;

public class AnyBaseMultiplication{

public static void main(String[] args) {
    try (Scanner scn = new Scanner(System.in)) {
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }
 }

 public static int getProduct(int b, int n1, int n2){
     // write your code here

     // AnyBaseToDecimal
        int ans1 = 0;
        int p1 = 1;
        while(n1>0){
            int d = n1%10;
            n1 = n1/10;
            ans1 = ans1 + d*p1;
            p1 = p1*b;
        }
 
         // AnyBaseToDecimal
         int ans2 = 0;
         int p2 = 1;
        while(n2>0){
            int d = n2%10;
            n2 = n2/10;
            ans2 = ans2 + d*p2;
            p2 = p2*b;
        }
 
         // Simple Decimal Multiplication
        int mult = ans1*ans2;
 
         // DecimalToAnyBase
         int p=1;
         int finalAns = 0;
        while(mult>0){
            int d = mult%b;
            mult = mult/b;
            finalAns = finalAns + d*p;
            p = p*10;
        }
 
        return finalAns;
 }

}


// TC =  O(log10m x log10n).
// SC = O(1)
