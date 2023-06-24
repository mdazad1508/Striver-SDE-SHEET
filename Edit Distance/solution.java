class Solution {
    public int minDistance(String word1, String word2) {

         //fun(3,4) - minmumun operration req to converst string1[0-3] to string2[0-4];
          int [][]dp  = new int [word1.length()][word2.length()];
          for(int []row: dp){
              Arrays.fill(row,-1);
          }
         return fun(word1.length()-1,word2.length()-1,word1,word2,dp);

        
        
    }

    static int fun(int index1, int index2, String word1, String word2,int[][]dp){

        if(index1 < 0){
            //fun(-1,3)-min op req to convert "" to string[0-3] : 4 insert operation
            return index2 +1;

        }

        if(index2 <0){
            //fun(3,-1)-min op req to convert string[0-3] to "" : 4 delete operation
            return index1 +1;
        }

        if(dp[index1][index2] !=-1){
            return dp[index1][index2];
        }

        if( word1.charAt(index1)==word2.charAt(index2)){
            //no operation 
            
            return dp[index1][index2] = fun(index1-1,index2-1,word1,word2,dp);
        }else{
            //operations need to perform 

            //option 1 : insert the same character in word1;
            
              int  o1 = 1 + fun(index1,index2-1,word1,word2,dp);
            
           

            //option 2 : delete the character from word 1
           
               int o2 = 1 + fun(index1-1,index2,word1,word2,dp);
            
           
            //option 3: replacing the character;
        
               int  o3 = 1 + fun(index1-1,index2-1,word1,word2,dp);
            
           
            return dp[index1][index2] =Math.min(o1,Math.min(o2,o3));

        }
    }
}