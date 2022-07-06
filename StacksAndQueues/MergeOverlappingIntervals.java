import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time

        Pair[] pairs = new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(i == 0){
                st.push(pairs[i]);
            }else{
                Pair top = st.peek();

                if(pairs[i].st > top.et){
                    st.push(pairs[i]);
                }else{
                    top.et = Math.max(pairs[i].et, top.et);
                }
            }
        }

        Stack<Pair> newSt = new Stack<>();
        while(st.size()>0){
            newSt.push(st.pop());
        }

        while(newSt.size()>0){
            Pair val = newSt.pop();
            System.out.println(val.st + " " + val.et);
        }


    }

    public static class Pair implements Comparable<Pair>{
        int st;
        int et;

        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }

        // if(this>other) = return +ve;
        // if(this == other) = return 0;
        // if(this<other) = return -ve;

        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st;
            }else{
                return this.et - other.et;
            }
        }
    }

}

// TC = O(NlogN);
// SC = O(N);