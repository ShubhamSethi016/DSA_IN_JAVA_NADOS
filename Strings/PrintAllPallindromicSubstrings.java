import java.util.Scanner;

public class PrintAllPallindromicSubstrings {

	public static void solution(String str){
		//write your code here
		for(int i=0;i<str.length();i++){
			for(int j=i;j<str.length();j++){
				String substr = str.substring(i,j+1);
				boolean check = isPallindrome(substr);
				if(check == true){
					System.out.println(substr);
				}
			}
		}
		
	}

	public static boolean isPallindrome(String s){
		int i=0;
		int j=s.length()-1;
		while(i<=j){
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			if(ch1 != ch2){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
            String str = scn.next();
            solution(str);
        }
	}

}

// TC = O(N^3) for using 3 nested for loops => i and j and then for substring pallindrome checking
// SC = O(N) for passing substring to isPallindrome function