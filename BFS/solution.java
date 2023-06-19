class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
       boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        ArrayList<Integer> ans = new ArrayList<>();
        
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
        
        return ans;