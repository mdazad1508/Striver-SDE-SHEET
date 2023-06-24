class Solution
{
	public int maxSumIS(int arr[], int n)  

	{  
	 int [][] dp = new int[arr.length][arr.length];
     for(int [] row : dp){
         Arrays.fill(row,-1);
     }
	    //fun(4,2) starting from 2 se lekar index 4 tak maximum sum of strictly increasing sub sequence;
	    return fun(0,-1,arr,dp);
	    
	} 
	static int fun(int index,int prev,  int arr[],int [][] dp){
	    
	    if(index==arr.length){
	        return 0;
	    }
	    
	    if(dp[index][prev+1] != -1){
	        return dp[index][prev+1];
	    }
	    
	    
	    //pick 
	    int pick = Integer.MIN_VALUE;
	    if(prev ==-1 || arr[index] > arr[prev]){
	        pick = arr[index] + fun(index+1,index,arr,dp);
	    }
	    
	    
	    //not pick
	    
	    int notPick = 0 + fun(index+1,prev,arr,dp);
	    
	    return dp[index][prev+1] = Math.max(pick,notPick);
	}
}