// import java.util.*;
import java.util.Scanner;
  
  public class countDigitsInNumber{
  
  public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int count = 0;
    while(n>0){
      int dig = n%10;
      count++;
      n = n/10;
      System.out.println(dig);
    }
    System.out.println("Total Digits: " + count);
    scn.close();  
   }
  }