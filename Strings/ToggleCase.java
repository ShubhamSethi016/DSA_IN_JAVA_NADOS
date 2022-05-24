import java.util.*;

public class ToggleCase {

	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();

		String ans = "";
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch>='A' && ch<='Z'){
				char lowerCase = (char)(ch + 'a' - 'A');
				ans = ans + lowerCase;
			}else if(ch>='a' && ch<='z'){
				char upperCase = (char)(ch + 'A' - 'a');
				ans = ans + upperCase;
			}
		}

		System.out.println(ans);
        scn.close();
	}
}

// TC = O(N)
// SC = O(str.length()) for ans output