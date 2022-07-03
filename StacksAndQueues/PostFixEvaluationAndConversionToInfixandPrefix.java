import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixEvaluationAndConversionToInfixandPrefix{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);

        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            int v2 = value.pop();
            int v1 = value.pop();
            int result = operation(v1, v2, ch);
            value.push(result);

            String infixV2 = infix.pop();
            String infixV1 = infix.pop();
            String infixV = "(" + infixV1 + ch + infixV2 + ")";
            infix.push(infixV);

            String preV2 = prefix.pop();
            String preV1 = prefix.pop();
            String preV = ch + preV1 + preV2;
            prefix.push(preV);
        }else {
            value.push(ch - '0');
            infix.push(ch + "");
            prefix.push(ch + "");
        }
    }
    System.out.println(value.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
 }

 public static int operation(int v1, int v2, char oprtor){
     if(oprtor == '+'){
         return v1 + v2;
     }else if(oprtor == '-'){
         return v1- v2;
     }else if(oprtor == '*'){
         return v1*v2;
     }else if(oprtor == '/'){
         return v1/v2;
     }else{
         return 0;
     }
 }
}

// TC = O(N);
// SC = O(N);