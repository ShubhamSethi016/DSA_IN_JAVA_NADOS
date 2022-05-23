import java.util.*;

public class DiffOf2Arrays{

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

    int[] ans = new int[n2];
    
    int i = n1-1;
    int j = n2-1;
    int k = ans.length-1;

    int c = 0;

    while(j>=0){
        int val1 = 0;
        if(i>=0){
            val1 = arr1[i];
        }

        if(arr2[j]+c>=val1){
            ans[k] = (arr2[j]+c) - val1;
            c = 0;
        }else{
            ans[k] = (arr2[j]+c+10) - val1;
            c = -1;
        }

        i--;
        j--;
        k--;
    }

    // for rmoving the initial zero places.
    int idx = 0;
    while(idx<ans.length && ans[idx] == 0){
        idx++;
    }

    for(int l = idx;l<ans.length;l++){
        System.out.println(ans[l]);
    }
    
    scn.close();
 }

}

// TC = O(N)
// SC = O(N)