import java.util.*;

public class ConstructorOfBinaryTree {
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

  public static Node construct(Integer[]arr) {
    Node root = new Node(arr[0], null, null);

    Stack<Pair>st = new Stack<>();
    Pair rtp = new Pair(root, 1);

    st.push(rtp);
    int idx = 0;

    while (st.size() > 0) {
      Pair top = st.peek();

      if (top.state == 1) {
        //waiting for left child
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair leftPair = new Pair(top.node.left, 1);
          st.push(leftPair);
        }else{
            top.node.left = null;
        }
        top.state++;
      }
      else if (top.state == 2) {
        //waiting for right child
        idx++;
        if (arr[idx] != null) {
            top.node.right = new Node(arr[idx], null, null);
            Pair rightPair = new Pair(top.node.right, 1);
            st.push(rightPair);
        }else{
            top.node.right = null;
        }
        top.state++;
      }
      else if (top.state == 3) {
        st.pop();
      }
    }
    return root;

  }

  public static void main(String[]args) {
    Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

    Node root = construct(arr);
  }
}

// TC = O(N) for N elements traversed
// SC = O(N) used by Stack