import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PrintSingleChildNodes {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void printSingleChildNodes(Node node, Node parent){
    // write your code here
    if(node == null){
      return;
    }

    if(parent != null && parent.left == node && parent.right == null){
      System.out.println(node.data);
      return;
    }

    if(parent != null && parent.right == node && parent.left == null){
      System.out.println(node.data);
      return;
    }

    printSingleChildNodes(node.left, node);
    printSingleChildNodes(node.right, node);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    printSingleChildNodes(root, null);
  }

}

// TC = O(N)
// SC = O(logN)

// Note: We have been applying this check for every node and we will apply this check for every node except the root node. 
// This is because the root node does not have any parent. So, we can say that we will apply this check only if the parent is not equal to null i.e. the node is not a root node. 
// So, there are two base cases:
// Base Case:

// 1 . When the node becomes null (we reach a leaf node): return null


// 2 . When the parent of the current node has only this child: print child