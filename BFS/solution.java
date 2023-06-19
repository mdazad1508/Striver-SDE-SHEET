
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
       boolean [] visited = new boolean[V];
       
       ArrayList<Integer> ans = new ArrayList<>();
       
       for(int i=0;i<V;i++){
           if(!visited[i]){
               bfs(i,adj,visited,ans);
           }
       }
        
       return ans;
        
    }
    static void bfs(int root,ArrayList<ArrayList<Integer>> adj,boolean [] visited, ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
            
            if(!visited[curr]){
                ans.add(curr);
                visited[curr] = true;
                
                //adding neighbours;
                
                
                for(int neighbour : adj.get(curr)){
                    
                    if(!visited[neighbour]){
                        q.add(neighbour);
                    }
                }
                
            }
        }
        
    }
}