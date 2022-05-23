import java.util.*;
    
    public class GCDandLCM{
    
    public static void main(String[] args) {
      // write your code here  
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int div = a;
        int divi = b;

        while(divi%div !=0){
          int rem = divi%div;
          divi = div;
          div = rem;
        }

        int lcm = div;
        int gcd = (a*b)/lcm;
        System.out.println(lcm);
        System.out.println(gcd);
        scn.close();  
     }
    }