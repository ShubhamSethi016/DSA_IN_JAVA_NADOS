import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimesFromArraylist {

	public static void solution(ArrayList<Integer> al){
		// write your code here
		for(int i=al.size()-1;i>=0;i--){
			int val = al.get(i);
			boolean check = isPrime(val);
			if(check == true){
				al.remove(al.get(i));
			}
		}		
	}

	public static boolean isPrime(int val){
		int count = 0;

		for(int i=2;i*i<=val;i++){
			if(val%i == 0){
				count = 1;
				break;
			}
		}

		if(count == 0){
			return true;
		}else{
			return false;
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
        scn.close();
	}

}

// TC = O(sqrt(N) *N) => sqrt(N) for checking of prime number and O(N) for traversing the list HENCE O(sqrt(N)*N)
// SC = O(1) 