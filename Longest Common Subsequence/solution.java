class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

       // fun(2,3,s1,s2) - lCS from s1[0 to 2] and s2[0,3]
        int [][] dp = new int[text1.length()][text2.length()];

        for(int []row : dp){
            Arrays.fill(row,-1);
        }
       return fun(text1.length()-1,text2.length()-1,text1,text2,dp);

       
        
    }
    static int fun(int index1, int index2 , String s1 , String s2,int[][] dp){
          
        if(index1 <0 || index2 <0){
            return 0;
        }


        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }


        if(s1.charAt(index1)==s2.charAt(index2)){
          //if matching it will definatley contribute to longest common subsequnce , so don't neet  to 
         // to check for other cases 
         
         return dp[index1][index2] = 1 + fun(index1-1, index2-1, s1,s2,dp);


        }else{
            
            //not matching : 2 cases
            //by decreasing only index1 may match index2 ;
            //by decreasing only index2 may match index1 ;

            int l1 = 0 + fun(index1-1,index2,s1,s2,dp);
            int l2 = 0 + fun(index1,index2-1,s1,s2,dp);
            
            return dp[index1][index2] =Math.max(l1,l2);

        }
    }
}