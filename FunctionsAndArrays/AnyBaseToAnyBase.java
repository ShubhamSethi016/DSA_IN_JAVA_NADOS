import java.util.*;
  
  public class AnyBaseToAnyBase{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();

      // AnyBaseToDecimal
       int p1 = 1;
       int ans1 = 0;
      while(n>0){
        int d = n%10;
        n = n/10;
        ans1 = ans1 + d*p1;
        p1 = p1*sourceBase;
      }

      // DecimalToAnyBase
      int p2 = 1;
      int finalAns = 0;
      while(ans1>0){
        int d = ans1%destBase;
        ans1 = ans1/destBase;
        finalAns = finalAns + d*p2;
        p2 = p2*10;

      }

      System.out.println(finalAns);

     scn.close();
   }   
  }

// TC = O(log10(n) + log10(n)) = O(log10(n))
// Sc = O(1)