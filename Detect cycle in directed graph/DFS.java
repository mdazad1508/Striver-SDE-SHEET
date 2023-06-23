
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean [] visited = new boolean[V];
        boolean [] dfsVisited = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,visited,dfsVisited,adj)==true){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    static boolean dfs(int root, boolean[] visited,boolean [] dfsVisited,ArrayList<ArrayList<Integer>> adj){
       
        
        visited[root] = true;
        dfsVisited[root] = true;
        
        for(int neighbour: adj.get(root)){
            
            if(!visited[neighbour]){
               if(dfs(neighbour,visited,dfsVisited,adj)==true){
                   return true;
               }
               
            }else{
                //it has been visited already,check if its visited in current dfs or not
    
                if(dfsVisited[neighbour]){
                    return true;
                }
                
            }
        }
        
        dfsVisited[root] = false;
        
        return false;
        
    }