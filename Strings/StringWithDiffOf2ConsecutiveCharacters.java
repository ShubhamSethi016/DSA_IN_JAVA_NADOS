import java.util.*;

public class StringWithDiffOf2ConsecutiveCharacters {

	public static String solution(String str){
		// write your code here
		StringBuilder ans = new StringBuilder();
		ans.append(str.charAt(0));
		for(int i=1;i<str.length();i++){
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);
			int diff = curr - prev;
			ans.append(diff);
			ans.append(curr);
		}
		

		return ans.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
        scn.close();
	}
}

// TC = O(N)
// SC = O(N)