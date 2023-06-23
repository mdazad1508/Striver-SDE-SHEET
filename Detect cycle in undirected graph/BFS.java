

class Solution {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V];
        
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                
                if(bfs(i,visited,adj)) return true;
            }
        }
        
        return false;
        
       
    }
    
    static boolean bfs(int root, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        
       
        visited[root] =true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,-1));   //no parent of root;

        while(!q.isEmpty()){

            Pair curr = q.poll();
            int node = curr.node;
            int parent = curr.parent;

            for(int neighbour : adj.get(node) ){

            if(!visited[neighbour]){
                        visited[neighbour] = true;
                        q.add(new Pair(neighbour,node));
             }else {
                    if(neighbour != parent) return true;
            }
            
            }   
        
          
        }

        return false;
    }
}