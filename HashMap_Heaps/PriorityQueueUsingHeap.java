import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PriorityQueueUsingHeap {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      // addition in arraylist takes place at last index;
      data.add(val);
      // and after addition, upHeapify is called for last idx element to check for HOP property;
      upHeapify(data.size() - 1);
    }

    private void upHeapify(int i){
      // base case;
        if(i == 0){
        return;
      }

      // parent index(pi);
      int pi = (i-1)/2;
      // for HOP property => pi should have high priority(means sammler value than both the child of it);
      // if pi has greater value means HOP is violated Hence seap pi element with the ith idx element;
      // and again call for upHeapify for that pi;
      if(data.get(i) < data.get(pi)){
        swap(i, pi);
        upHeapify(pi);
      }
    }

    // swapping in arraylist;
    private void swap(int i, int j){
      int ith = data.get(i);
      int jth = data.get(j);
      data.set(i, jth);
      data.set(j, ith);
    }

    public int remove() {
      // write your code here
      if(this.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      // for removal, it will be done at last index as TC at last index for removal is O(1);
      // Hence swapped the 0th element and last element adn removed the last element which is basically our 0th element only;
      // and then called downHeapify for 0th idx to satisfy HOP property;
      swap(0, data.size() - 1);
      int val = data.remove(data.size()-1);
      downHeapify(0);
      return val;
    }


    // In downHeapify, we are checking the idx for the smallest element among (pi, lchild & rchild);
    // if idx comes out to be of pi only,then that means our HOP propoerty is satisfied;
    // else swap the pi element with the smallest element b/w lchild & rchild; 
    // and again call downHeapify for that element swapped(smallest b/w child and rchild); 

    private void downHeapify(int pi){
      int minIdx = pi;

      int li = 2*pi + 1;
      if(li<data.size() && data.get(li)<data.get(minIdx)){
          minIdx = li;
      }

      int ri = 2*pi + 2;
      if(ri<data.size() && data.get(ri)<data.get(minIdx)){
          minIdx = ri;
      }

      if(minIdx != pi){
        swap(minIdx, pi);
        downHeapify(minIdx);
      }
    }


    // for peek() => it will return 0th idx element which is our smallest element acc to HOP property;
    // TC = O(1);
    public int peek() {
      // write your code here
      if(this.size() == 0){
        System.out.println("Underflow");
        return -1;
      }

      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}

// TC = O(NlogN) for add() & remove();
// TC = O(1) for size() & peek();

// SC = O(N);