import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        HashMap<Character, Integer> map = new HashMap<>();

        char ans = ' ';
        int freq = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch) == true){
                int val = map.get(ch);
                val++;
                map.put(ch, val);
            }else{
                map.put(ch, 1);
            }

            if(map.get(ch) > freq){
                freq = map.get(ch);
                ans = ch;
            }
        }

        System.out.println(ans);
        scn.close();
    }

}

// TC = O(N) for traversal.
// SC = O(N) for storing char in map.