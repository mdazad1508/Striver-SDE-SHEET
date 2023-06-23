class Solution {
    public boolean isBipartite(int[][] graph) {
        
        //bipartite means , no two neighbours should have same color;
        
         String[] color = new String[graph.length];
         boolean [] visited = new boolean[graph.length];
         
         for(int i=0;i<graph.length;i++){
              if(!visited[i]){
                  color[i] = "black";
                  if(dfs(i,visited,color,graph)==false){
                      return false;
                  }
              }
         }

         return true;


    }
    static boolean dfs(int root,boolean [] visited, String[] color , int[][] graph ){

        visited[root] = true;
        String currColor = color[root];


        for(int neighbour : graph[root]){
            
            if(!visited[neighbour]){
                if(currColor.equals("black")) color[neighbour] = "white";
                else color[neighbour] ="black";
                if(dfs(neighbour,visited,color,graph)==false) return false;
            }else{
               if(currColor.equals(color[neighbour])){
                   return false;
               }
            }
        }

        return true;



    }
}