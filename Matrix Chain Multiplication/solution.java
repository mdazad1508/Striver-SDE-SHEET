class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // Patition DP question
        //steps : 
        
        //1. start with the entire block f(i,j) i - start, j - end
        //2.try all partition (run a loop to try all partition)
        //3.return the best possbile partition
        
        //i`th  matrix = arr[i-1]xarr[i]
        //1st matrix = arr[0] x arr[1]
        //4th matrix = arr[3] x arr[4];
        
        int i = 1; 
        int j = arr.length-1;
        
         int [][] dp = new int[arr.length][arr.length];
         for(int [] row : dp){
           Arrays.fill(row,-1);
         }
        
        return fun(i,j,arr,dp);
        
       // fun(1,4)- minimum MCM if we try to multiply from matrix 1 to matrix 4
        
    }
    
    static int fun(int i,int j,int[] arr,int[][] dp){
        if(i==j){
            //basically no operation,there is only one matrix
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int k = i; k <j;k++){
            //k is the point at which partion occurs;
            // [40,20|,30,10,30]   20 and  (30,10,30) => 40x20 and 20x30 x 30x10 x 10x30 =>
            //40x20 and 20x10 x 10x30 => 40x20 and 20x30 => 40(i-1)x20(k)x30(j)=total no of muliplication of 2 partions
            //plus we will have mcm from other 2 partions
            int val = arr[i-1] * arr[k] * arr[j] + fun(i,k,arr,dp) + fun(k+1,j,arr);
            ans = Math.min(ans,val);
        }
        
        return dp[i][j] = ans;
       
    }
}