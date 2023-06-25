class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

      int low = 0;
      int high = matrix[0].length-1;

      while(low < matrix.length && high >=0){

          if(matrix[low][high]==target){
              return true;
          }else if(target<matrix[low][high]){
              high--;
          }else{
              low++;
          }
      }

      return false;
        
    }
}