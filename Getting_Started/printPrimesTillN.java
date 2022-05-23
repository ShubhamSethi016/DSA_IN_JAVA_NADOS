import java.util.*;

public class printPrimesTillN{
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        
        while(low<=high){
            int count = 0;
            for(int i=2;i*i<=low;i++){
                if(low%i == 0){
                    count = 1;
                }
            }
            if(count == 0){
                System.out.println(low);
                
            }
            low++;
        }
        scn.close();  
    }
}