class Solution {
   
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V];
        
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                
                if(dfs(i,-1,visited,adj)) return true;
            }
        }
        
        return false;
        
       
    }
    
    static boolean dfs(int root,int parent , boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        
      
       visited[root] =true;
       
       for(int i=0;i<adj.get(root).size();i++){
           
           int neighbour = adj.get(root).get(i);
           
           if(!visited[neighbour]){
               if(dfs(neighbour,root,visited,adj)){
                   return true;
               }
           }else{
               if(neighbour != parent){
                   return true;
               }
           }
       }
       
       return false;
      
    }
}