import java.util.Scanner;

public class PrintPermutationsOfStringIteratively {

	public static void solution(String str){
		// write your code here
		int n = str.length();
		int f = factorial(n);

		for(int i=0;i<f;i++){
			StringBuilder sb = new StringBuilder(str);
			int temp = i;
			for(int div = n;div>=1;div--){
				int q = temp/div;
				int r = temp%div;

				System.out.print(sb.charAt(r));
				sb.deleteCharAt(r);
				temp = q;
			}		
			System.out.println();
		}
		
	}

	public static int factorial(int n){
		int fact = 1;
		for(int i=1;i<=n;i++){
			fact = fact*i;
		}
		return fact;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
        scn.close();
	}

}

// TC = O(N*N!); where N! = for factorial and N for div loop.
// SC = O(1);