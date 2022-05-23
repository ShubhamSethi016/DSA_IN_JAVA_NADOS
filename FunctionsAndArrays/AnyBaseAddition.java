import java.util.*;
  
  public class AnyBaseAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
      scn.close();
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here

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
 
         // Simple Decimal Addition
        int sum = ans1+ans2;
 
         // DecimalToAnyBase
         int p=1;
         int finalAns = 0;
        while(sum>0){
            int d = sum%b;
            sum = sum/b;
            finalAns = finalAns + d*p;
            p = p*10;
        }
 
        return finalAns;

   }
  }

// TC =  O(log10(max(n1, n2))
// SC = O(1)