
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        //KAHN'S ALGORITHM 
        
        int[] indegreeCount = new int[V];
        
        for(int i=0;i<adj.size();i++){
            
            for(int node : adj.get(i)){
                
                indegreeCount[node]++;
            }
        }
        
        Queue<Integer> q= new LinkedList<>();
        
        //Topological sort is only for DAG element , so there will be atleast one 
        //element whose indegreeCount = 0;
        
        for(int i=0;i<indegreeCount.length;i++){
            if(indegreeCount[i]==0){
                q.add(i);
            }
        }
        
        
        int [] ans = new int[V];
        int index=0;
        
        while(!q.isEmpty()){
            
            int elem = q.poll();
            ans[index] = elem;
            index++;
            
            
            //removing this element will cause in decreease of indegreeCOunt of its neighbours
            
            for(int neighbour : adj.get(elem)){
                indegreeCount[neighbour]--;
                
                if(indegreeCount[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        
        return ans;
        
    }
    
}