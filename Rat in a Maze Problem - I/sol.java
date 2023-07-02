class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        boolean [][] visited = new boolean[n][n];
        
         
        
         //occupying the first position , kyuki down hoke firse up ja skta hai ...
        ArrayList<String> ans =new ArrayList<>(); 
        if(m[0][0]==0) return ans;
        fun(0,0,"",m,visited,ans,n);
        return ans;
        
    }
    static void fun(int row, int col,String s,int [][] m,boolean [][] visited,ArrayList<String> ans,int n){
        
        if(row==n-1 && col ==n-1){
            ans.add(s);
            return;
        }
        
        
        //check if it can go up
        
        if(row-1 >=0 && isPossiblePath(row-1,col,m,visited)){
            visited[row][col]= true;
            fun(row-1,col,s+"U",m,visited,ans,n);
            visited[row][col] = false;
            
        }
        
        //down
        
         if(row+1<n  && isPossiblePath(row+1,col,m,visited)){
            visited[row][col]= true;
            fun(row+1,col,s+"D",m,visited,ans,n);
            visited[row][col] = false;
            
        }
        
        //left
        
         if(col-1 >=0 && isPossiblePath(row,col-1,m,visited)){
            visited[row][col]= true;
            fun(row,col-1,s+"L",m,visited,ans,n);
            visited[row][col] = false;
            
        }
        
        //right
        
       if(col+1 <n && isPossiblePath(row,col+1,m,visited)){
            visited[row][col]= true;
            fun(row,col+1,s+"R",m,visited,ans,n);
            visited[row][col] = false;
            
        }
    }
    
    static boolean isPossiblePath(int row, int col,int [][]m , boolean[][] visited){
        
        if(m[row][col]==1 && !visited[row][col]){
            return true;
        }
        
        return false;
    }
    
    
    
    
}