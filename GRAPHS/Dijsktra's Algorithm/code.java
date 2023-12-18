
import java.util.*;
class Solution
{
    
    static int[] dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V)
    {
       int dist[] = new int[V];
       boolean set[] = new boolean[V];
       
       Arrays.fill(dist,Integer.MAX_VALUE);
       
       dist[src]=0;
       
       for(int i=0;i<V;i++)
       {
           int u = minDistance(list,dist,set,V);
           set[u]=true;
           
           for(int v=0;v<V;v++)
           {
               if(set[v]==false && list.get(u).get(v)!=0 && dist[u]!=Integer.MAX_VALUE)
               dist[v] = Math.min(dist[v],dist[u]+list.get(u).get(v));
           }
       }
       
      return dist;
    }
    
    static int minDistance(ArrayList<ArrayList<Integer>> list,int dist[],boolean set[],int V)
    {
      int min  = Integer.MAX_VALUE;
      int min_index = -1;
      for(int i=0;i<V;i++)
      {
          if(set[i]==false && dist[i]<min)
          {
              min = dist[i];
              min_index = i;
          }
      }
      
      return min_index;
    }
}
