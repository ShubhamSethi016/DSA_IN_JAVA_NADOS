import java.util.*;
    
    public class DigitsOfNumber{
    
    public static void main(String[] args) {
      // write your code here  
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int count = 0;
      int temp = n;
      while(temp>0){
        temp = temp/10;
        count++;
      }

      while(count>0){
        int d = n/(int)Math.pow(10,count-1);
        n= n%(int)Math.pow(10,count-1);
        System.out.println(d);
        count--;
      }
      scn.close();  
     }
    }