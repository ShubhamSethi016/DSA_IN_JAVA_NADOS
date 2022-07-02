import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code

    Stack<Integer> oprands = new Stack<>();
    Stack<Character> oprtors = new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);

        if(ch == '('){
            oprtors.push(ch);
        }else if(ch == ')'){
            while(oprtors.peek() != '('){
                int v2 = oprands.pop();
                int v1 = oprands.pop();

                char optor = oprtors.pop();

                int result = operation(v1, v2, optor);
                oprands.push(result);
            }
            oprtors.pop();

        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(oprtors.size() >0 && oprtors.peek() != '(' && 
                precedence(ch) <= precedence(oprtors.peek())){
                    int v2 = oprands.pop();
                    int v1 = oprands.pop();

                    char optor = oprtors.pop();

                    int result = operation(v1, v2, optor);
                    oprands.push(result);
                }

                oprtors.push(ch);
        }else if(Character.isDigit(ch)){
            int val = ch - '0';
            oprands.push(val);
        }
    }

    while(oprtors.size() != 0){
        int v2 = oprands.pop();
        int v1 = oprands.pop();
        char optor = oprtors.pop();

        int result = operation(v1, v2, optor);
        oprands.push(result);
    }

    System.out.println(oprands.peek());
 }

 public static int precedence(char optor){
     if(optor == '+'){
         return 1;
     }else if(optor == '-'){
         return 1;
     }else if(optor == '*'){
         return 2;
     }else if(optor == '/'){
         return 2;
     }

     return 0;
 }

 public static int operation(int v1, int v2, char optor){
     if(optor == '+'){
         return v1+v2;
     }else if(optor == '-'){
         return v1-v2;
     }else if(optor == '*'){
         return v1*v2;
     }else if(optor == '/'){
         return v1/v2;
     }
     return 0;
 }
}

// TC = O(N);
// SC = 2 stacks are used but at any moment, So the total space used will be less than or equal to O(N), 
// making the space complexity O(N);