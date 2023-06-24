class Solution {
    public int lengthOfLIS(int[] nums) {


     //fun(3,1) - LIS from index 3 if the prev index was 1;

     //index: 0 to n-1 
     //prev: -1 to n-2  we can't store index -1 to coordinate shift index by 1 ;
     //so storing -1 at 0 , 0 at 1 etc...n-2 at n-1
     int [][] dp = new int[nums.length][nums.length];
     for(int [] row : dp){
         Arrays.fill(row,-1);
     }
     return fun(0,-1,nums,dp);
        
    }
    static int fun(int index , int prevIndex , int [] nums,int [][] dp){

        if(index==nums.length){
            return 0;
        }


        if(dp[index][prevIndex+1] != -1){
            return dp[index][prevIndex+1];
        }

      
       //not take : prevIndex will remain same and length will not increase

       int len1 = 0 + fun(index+1, prevIndex, nums,dp);


       //take : length will increase , prevIndex will change , but take only if is first element or 
       // next nums[index] > nums[prevIndex] ;
        
        int len2 = Integer.MIN_VALUE;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){

          len2 = 1 + fun(index+1, index, nums,dp);
        }
       
       return dp[index][prevIndex+1] = Math.max(len1,len2);

 
    }
}