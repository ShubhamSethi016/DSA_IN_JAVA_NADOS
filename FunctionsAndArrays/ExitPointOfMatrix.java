import java.util.Scanner;

public class ExitPointOfMatrix {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int dir = 0; //East->0 South->1 West->2 North->3

        int i = 0;
        int j = 0;
        while(true){
            dir = (dir + arr[i][j])%4;

            if(dir == 0){ // east => row fixed, col++;
                j++;
            }else if(dir == 1){ // south => col fixed, row++;
                i++;
            }else if(dir == 2){ // west => row fixed, col--;
                j--;
            }else if(dir == 3){ // north => col fixed, row--;
                i--;
            }

            // means our exit point is generated but it has crossed the matrix.
            // Hence keeping an if check on all the boundary conditions and then generating the exit point.
            
            if(i<0){
                i++; 
                break;
            }else if(j<0){
                j++;
                break;
            }else if(i == n){
                i--;
                break;
            }else if(j == m){
                j--;
                break;
            }
        }

        System.out.println(i);
        System.out.println(j);

        scn.close();
    }

}

// TC = O(N*M);
// SC = O(1)