import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PreFixEvaluationAndConversionToInfixandPostfix{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    for(int i=exp.length()-1;i>=0;i--){
        char ch = exp.charAt(i);

        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int v1 = value.pop();
            int v2 = value.pop();
            int result = operation(v1, v2, ch);
            value.push(result);

            String infixV1 = infix.pop();
            String infixV2 = infix.pop();
            String infixV = "(" + infixV1 + ch + infixV2 + ")";
            infix.push(infixV);
            
            String postfixV1 = postfix.pop();
            String postfixV2 = postfix.pop();
            String postfixV = postfixV1 + postfixV2 + ch;
            postfix.push(postfixV);
            
        }else{
            value.push(ch - '0');
            infix.push(ch + "");
            postfix.push(ch + "");
        }
    }

    System.out.println(value.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());

 }

 public static int operation(int v1, int v2, char oprtor){
     if(oprtor == '+'){
         return v1 + v2;
     }else if(oprtor == '-'){
         return v1- v2;
     }else if(oprtor == '*'){
         return v1*v2;
     }else{
         return v1/v2;
     }
 }
}

// TC = O(N);
// SC = O(N);