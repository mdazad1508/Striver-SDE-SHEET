class Solution {
    public boolean isBipartite(int[][] graph) {
        
        //bipartite means , no two neighbours should have same color;
        
         String[] color = new String[graph.length];
         boolean [] visited = new boolean[graph.length];
         
         for(int i=0;i<graph.length;i++){
              if(!visited[i]){
                  if(bfs(i,visited,color,graph)==false){
                      return false;
                  }
              }
         }

         return true;


    }
    static boolean bfs(int root,boolean [] visited, String[] color , int[][] graph ){

        Queue<Integer> q = new LinkedList<>();
        color[root] = "black";
        q.add(root);

        while(!q.isEmpty()){
            int curr = q.poll();
            visited[curr] = true;
            String currColor = color[curr];

            //adding opposite color to neigbours;

            for(int neighbour : graph[curr]){

                    if(color[neighbour]==null){
                        if(currColor.equals("black")) color[neighbour] = "white";
                        else color[neighbour] = "black";
                        q.add(neighbour);
                    }else{
                        if(currColor.equals(color[neighbour])){
                            return false;
                        }else{
                            if(!visited[neighbour]) q.add(neighbour);
                        }

                    
                }
            }
        }
        return true;
    }
}