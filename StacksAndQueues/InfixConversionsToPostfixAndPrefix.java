import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixConversionsToPostfixAndPrefix{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);

        if(ch == '('){
            operators.push(ch);
        }else if(ch == ')'){
            while(operators.peek() != '('){
                char op = operators.pop();

                String postV2 = postfix.pop();
                String postV1 = postfix.pop();

                String postV = postV1 + postV2 + op;
                postfix.push(postV);

                String preV2 = prefix.pop();
                String preV1 = prefix.pop();
                String preV = op + preV1 + preV2;
                prefix.push(preV);
            }
            operators.pop();
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operators.size() > 0 && operators.peek() != '(' 
                    && precedence(ch) <= precedence(operators.peek())){
                char op = operators.pop();

                String postV2 = postfix.pop();
                String postV1 = postfix.pop();

                String postV = postV1 + postV2 + op;
                postfix.push(postV);

                String preV2 = prefix.pop();
                String preV1 = prefix.pop();
                String preV = op + preV1 + preV2;
                prefix.push(preV);
            }
            operators.push(ch);
        }else if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') ||
                    (ch>='A' && ch<='Z')){
            prefix.push(ch + "");
            postfix.push(ch + "");
        }
    }

    while(operators.size() != 0){
                char op = operators.pop();

                String postV2 = postfix.pop();
                String postV1 = postfix.pop();

                String postV = postV1 + postV2 + op;
                postfix.push(postV);

                String preV2 = prefix.pop();
                String preV1 = prefix.pop();
                String preV = op + preV1 + preV2;
                prefix.push(preV);
    }

    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
 }

 public static int precedence(char oprtor){
     if(oprtor == '+'){
         return 1;
     }else if(oprtor == '-'){
         return 1;
     }else if(oprtor == '*'){
         return 2;
     }else if(oprtor == '/'){
         return 2;
     }else{
         return 0;
     }
 }
}

// TC = O(N);
// SC = O(N);