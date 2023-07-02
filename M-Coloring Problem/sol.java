class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            
            ArrayList<Integer> x = new ArrayList<>();
            
            for(int j=0;j<n;j++){
                
               if(i!=j && graph[i][j]){
                   x.add(j);
               }
                
            }
            
            list.add(x);
        }
        
        
        int [] color = new int[n];
        
        return fun(0,m,n,color,list);
    }
    
    static boolean fun(int node,int m,int n,int[]color,ArrayList<ArrayList<Integer>> list ){
        
        if(node==n){
            //we were able to color with m colors
            return true;
        }
        
        for(int col = 1;col<=m ;col++){
            
            
            if(isPossibletoColor(node,col,color,list)){
                color[node] = col;
                
                if(fun(node+1,m,n,color,list)) return true;
                
                color[node] = 0;
            }
        }
        
        return false;
        
    }
    
    static boolean isPossibletoColor(int node,int col, int []color,ArrayList<ArrayList<Integer>> list ){
        
        //check if its neighbours cotaining the same color;
        
        for(int i=0;i<list.get(node).size();i++){
            
            int neighbour =list.get(node).get(i);
            
            if(color[neighbour]==col){
                return false;
            }
        }
        
        return true;
        
    }
    
    