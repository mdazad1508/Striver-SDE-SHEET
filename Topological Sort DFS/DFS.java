class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        boolean [] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adj,st);
            }
        }    
        
        
        int [] ans = new int[V];
        int index =0;
        
        while(!st.isEmpty()){
            ans[index] = st.pop();
            index++;
        }
        
        return ans;
    }
    static void dfs(int root,boolean [] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> s){
        
        
        visited[root]=true;
        
        for(int neighbour : adj.get(root)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,adj,s);
            }
        }
        
        s.push(root);
    }
}
