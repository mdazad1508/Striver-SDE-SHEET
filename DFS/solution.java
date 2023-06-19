class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0,adj,visited,ans);
        
        return ans;
        
        
    }
    
    static void dfs(int root,ArrayList<ArrayList<Integer>> adj,boolean [] visited ,ArrayList<Integer> ans){
        
        if(visited[root] == true){
            return;
        }
        
        ans.add(root);
        visited[root] = true;
        
        for(int i=0;i<adj.get(root).size();i++){
            dfs(adj.get(root).get(i),adj,visited,ans);
        }
        
    }
}