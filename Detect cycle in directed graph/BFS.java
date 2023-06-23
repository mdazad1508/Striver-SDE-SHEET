class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int [] indegreeCount = new int[V];
        
        for(int i=0;i<adj.size();i++){
            
            for(int node : adj.get(i)){
                indegreeCount[node]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<indegreeCount.length;i++){
            if(indegreeCount[i]==0){
                q.add(i);
            }
        }
        
        
        int topoCount = 0;
        
        
        while(!q.isEmpty()){
            
            int curr = q.poll();
            topoCount++;
            
            for(int neighbour: adj.get(curr)){
                indegreeCount[neighbour]--;
                
                if(indegreeCount[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        
        
       if(topoCount == V) return false;
       
       return true;
       
        
    }
}