import java.util.*;
import java.util.Scanner;

public class BalancedBrackets{
   public static void main(String[] args) {
      try (Scanner scn = new Scanner(System.in)) {
        String str = scn.nextLine();

          Stack<Character> st = new Stack<>();

          for(int i=0;i<str.length();i++){
             char ch = str.charAt(i);

             if(ch =='(' || ch == '[' || ch == '{'){
                st.push(ch);
             }else if(ch == ')'){
                if(st.size() == 0 || st.peek()!='('){
                   System.out.println("false");
                   return;
                }
                st.pop();
             }else if(ch == ']'){
                if(st.size() == 0 || st.peek()!= '['){
                   System.out.println("false");
                   return;
                }

                st.pop();
             }else if(ch == '}'){
                if(st.size() == 0 || st.peek()!='{'){
                   System.out.println("false");
                   return;
                }

                st.pop();
             }else{
                //
             }
          }

          if(st.size()>0){
             System.out.println("false");
             return;
          }      

          System.out.println("true");
          scn.close();
    }
   }
}

// TC = O(N)
// SC = O(1)