import java.io.*;
import java.util.*;

public class IsBipartiteGraph {
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
      boolean ans = false;
      int[] color = new int[vtces];
      Arrays.fill(color, -1);
      for(int i=0;i<vtces;i++){
         if(color[i] == -1){
            ans = dfsCheckForBipartite(i, color, graph);
         }
      }

      System.out.println(ans);
   }

   public static boolean dfsCheckForBipartite(int node,
                              int[] color, ArrayList<Edge>[] graph){

         if(color[node] == -1){
            color[node] = 1;
         }

         for(Edge edge: graph[node]){
            if(color[edge.nbr] == -1){
               color[edge.nbr] = 1 - color[node];
               if(dfsCheckForBipartite(edge.nbr, color, graph) == false){
                  return false;
               }
            }else if(color[node] == color[edge.nbr]){
               return false;
            }
         }

         return true;
   }
}

// TC = O(V+E);
// SC = O(V);