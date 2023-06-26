class Solution {
    public int uniquePaths(int m, int n) {

        int [][]dp =new int[m+1][n+1];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        return fun(1,1,m,n,dp);
        
    }

    static int fun(int i, int j , int m , int n,int[][] dp){

        if(i==m && j==n){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //move right 
        
        int x1 = 0 ;
        if(j<n){
         x1 = fun(i,j+1,m,n,dp);
        }

        //move down 
        int x2 =0;
        if(i<m){
            x2 = fun(i+1,j,m,n,dp);
        }
        
        return dp[i][j] =x1 + x2;
    }
}