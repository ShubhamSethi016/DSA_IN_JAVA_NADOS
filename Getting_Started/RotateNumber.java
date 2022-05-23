import java.util.*;
   
   public class RotateNumber{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int k = scn.nextInt();

      int div=1;
      int mult=1;
      int temp = n;
      int count=0;
      while(temp>0){
        temp = temp/10;
        count++;
      }

      k = k%count;
      if(k<0){
        k = k + count;
      }
      for(int i=1;i<=count;i++){
        if(i<=k){
          div=div*10;
        }else{
          mult=mult*10;
        }
      }

      int r = n%div;
      int q = n/div;
      int ans = r*mult + q;
      System.out.println(ans);
      scn.close();  
    }
   }