import java.util.*;
   
   public class ReverseNumber{
   
   public static void main(String[] args) {
     // write your code here 
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      while(n>0){
        int d = n%10;
        n = n/10;
        System.out.println(d);
      }
      scn.close();  
    }
   }