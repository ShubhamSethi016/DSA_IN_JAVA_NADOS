import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class IsGraphCyclic {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static class Pair{
      int first;
      int second;

      Pair(int first, int second){
         this.first = first;
         this.second = second;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here

      boolean[] vis = new boolean[vtces];
      Arrays.fill(vis, false);

      for(int i=0;i<vtces;i++){
         if(vis[i] == false){
            if(bfsCycleCheck(i, graph, vis) == true){
               System.out.println("true");
               return;
            }
         }
      }

      System.out.println("false");
      
   }

   public static boolean bfsCycleCheck(int node, ArrayList<Edge>[] graph, boolean[] vis){

      Queue<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(node, -1));
      vis[node] = true;
      while(queue.size()>0){
         int remNode = queue.peek().first;
         int par = queue.peek().second;
         queue.remove();
         for(Edge edge: graph[remNode]){
            if(vis[edge.nbr] == false){
               queue.add(new Pair(edge.nbr, remNode));
               vis[edge.nbr] = true;
            }else if(par != edge.nbr){
               return true;
            }
         }
      }

      return false;
   }
}

// TC = O(V+E);
// SC = O(V);