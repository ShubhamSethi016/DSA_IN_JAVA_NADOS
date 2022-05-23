import java.util.*;
  
  public class isNumberPrime{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       int t = scn.nextInt();
       while(t-->0){
         int count = 0;
          int n = scn.nextInt();
          for(int i=2;i*i<=n;i++){
            if(n%i == 0){
              count = 1;
              break;
            }
          }
          if(count == 0){
            System.out.println("prime");
          }else{
            System.out.println("not prime");
          }

       }
       scn.close();  
   }
  }