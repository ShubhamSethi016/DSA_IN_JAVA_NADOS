import java.util.*;
  
  public class DecimalToAnyBase{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);

      scn.close();
   }
  
   public static int getValueInBase(int n, int b){
       // write code here

        int p = 1;
        int ans = 0;

        while(n>0){
            int d = n%b;
            n = n/b;
            ans = ans + d*p;
            p = p*10;
        }

        return ans;
   }
  }

// TC = O(logN)
// SC = O(1)