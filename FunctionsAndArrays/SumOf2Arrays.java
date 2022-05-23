import java.util.*;

public class SumOf2Arrays{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0;i<n1;i++){
        arr1[i] = scn.nextInt();
    }
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0;i<n2;i++){
        arr2[i] = scn.nextInt();
    }

    int carry = 0;
    
    int[] ans = new int[n1>n2?n1:n2];

    int i = n1-1;
    int j = n2-1;
    int k = ans.length-1;
   
    while(k>=0){
        int sum = 0;
        if(i>=0){
            int val1 = arr1[i];
            sum = sum + val1;         
        }

        if(j>=0){
            int val2 = arr2[j];
            sum = sum + val2;
        }
        

        sum = sum + carry;

        ans[k] = sum%10;
        carry = sum/10;

        i--;
        j--;
        k--;
    }

    if(carry!=0){
        System.out.println(carry);
    }

    for(int l=0;l<ans.length;l++){
        System.out.println(ans[l]);
    }

    scn.close();
 }

}

// TC = O(N)
// SC = O(N)