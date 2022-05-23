import java.util.*;
  
  public class AnyBaseToDecimal{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
      scn.close();
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
      int ans = 0;
      int p = 1;

      while(n>0){
         int d = n%10;
         n = n/10;
         ans = ans + d*p;
         p = p*b;
      }
      return ans;
   }
  }

// TC = O(logN)
// SC = O(1)