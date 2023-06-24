//greedy fails for this (you can't take portion)
/* int val = 20,25,60
int wt = 2,4,8
W = 12;
 */

class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n){
        
        int dp[][] = new int[wt.length][W+1];
        
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return fun(0,W,wt,val,dp);
        
        
    }
    static int fun(int index,int remWt,int wt[], int val[],int[][]dp){
        
        if(remWt==0){
            return 0;
        }
        
        if(index==wt.length){
            return 0;
        }
        
        if(dp[index][remWt] != -1){
            return dp[index][remWt];
        }
        
       
       //pick 
       int pick = Integer.MIN_VALUE;
       
       if(wt[index]<=remWt){
           pick = val[index] + fun(index+1,remWt-wt[index],wt,val,dp);
       }
       
       //not pick
 
       int notPick = 0+ fun(index+1,remWt,wt,val,dp);
       
      
       
       return dp[index][remWt]= Math.max(pick,notPick);
        
    }
   
   
}