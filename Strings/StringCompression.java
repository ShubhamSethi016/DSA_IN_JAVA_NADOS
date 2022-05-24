import java.util.*;

public class StringCompression {

	public static String compression1(String str){
		// write your code here
		String ans=str.charAt(0) + "";
		for(int i=1;i<str.length();i++){
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);
			if(curr!=prev){
				ans = ans + curr;
			}
		}
		return ans;
	}

	public static String compression2(String str){
		// write your code here
		String ans = str.charAt(0) + "";
		int count = 1;
		for(int i=1;i<str.length();i++){
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);
			if(curr == prev){
				count++;
			}else{
				if(count>1){
					ans = ans + count;
					count = 1;
				}
				ans = ans + curr;
			}
		}
		if(count>1){
			ans = ans+count;
		}

		return ans;
	}
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
            String str = scn.next();
            System.out.println(compression1(str));
            System.out.println(compression2(str));
        }
	}
}

// TC = O(N) + O(N) ~= O(N)
// SC = O(N) for storing the output string