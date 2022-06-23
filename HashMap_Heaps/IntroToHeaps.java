// When an element is removed from the Priority Queue, a certain "Priority" is followed.
// 1 => By default this priority is set to rank order. That means if you call remove() function then the number with lowest value will be removed from the Priority Queue.
// Let's take an example:
// Suppose we added 10, 80, 9, 33 and 2 in a Priority Queue, pq.
// And we call the peek() function.
// What do you think it should and have returned?
// Yes, Correct! 2. As it is the highest priority value in terms of rankings.
// And on calling remove() function. 2 gets removed from the pq.
// Now peek() will return 9 and remove() will remove 9 from pq.
// Now peek() will return 10 and remove() will remove 10 from pq.
// Now peek() will return 33 and remove() will remove 33 from pq.
// Now peek() will return 80 and remove() will remove 80 from pq.

// add(), remove() = O(logN)
// peek() = O(1) constant

// Code =>
import java.util.*;

public class IntroToHeaps {
  public static void main(String[] args) throws Exception {
    // Creation of Priority Queue of default type(high priority to lowest value)
    PriorityQueue< Integer> pq = new PriorityQueue< >();
    int[] ranks = {22, 99, 3, 11, 88, 4, 1};

    // Time complexity of the add(value) function is O(log n).
    // And since the for loop runs n times, therefore time complexity will be n*O(log n) or O(n log n)
    for (int val: ranks) {
      pq.add(val);
    }

    // Time complexity of remove() function is O(log n) and peek() function is constant.
    // And since the for loop runs n times, therefore time complexity will be n*O(log n) or O(n log n).
    while (pq.size() > 0) {
      System.out.println(pq.peek());
      pq.remove();
    }

    // output => 1 3 4 11 22 88 99
  }
}


// 2 =>
// But what if we need to change this priority order?
// We can change this order by simply adding some magical words in the parenthesis of the Priority Queue constructor while defining any Priority Queue. 
// And those magical words are Collections.reverseOrder()

// PriorityQueue< Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
// i,e; high priority given to largest value. 
// output of above code with largest value priorrity :- 
// 99 88 22 11 4 3 1
