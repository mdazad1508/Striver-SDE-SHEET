
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //cycle - can't perform the task;
        //no cycle - can perform the task;

        //the pair [0, 1], indicates that to take course 0 you have to first take course 1.
        //which means 1 should be directed towards 0 
        // 1--->0 should be graph 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] pair : prerequisites){
            adj.get(pair[1]).add(pair[0]);
        }


        boolean visited[] = new boolean[numCourses];
        boolean dfsVisited[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(DFS(i,visited,dfsVisited,adj)==true){
                    return false;
                }
            }
        }

        return true;        
    }
    static boolean DFS(int root,boolean[] visited, boolean []dfsVisited, ArrayList<ArrayList<Integer>> adj){
       //for directed

        visited[root] = true;
        dfsVisited[root] = true;

        for(int neighbour: adj.get(root)){

            if(!visited[neighbour]){
               if(DFS(neighbour,visited,dfsVisited,adj)==true){
                   return true;
               }
            }else{
                if(dfsVisited[neighbour]){
                    return true;
                }
            }
        }

        dfsVisited[root] = false;

        return false;
    }

    
}