class Solution {
    public int maxProduct(int[] nums) {
       
       int prefix =1;
       int maxLeft = Integer.MIN_VALUE;

       
       for(int i=0;i<nums.length;i++){

           prefix = prefix*nums[i];
           maxLeft = Math.max(maxLeft,prefix);

           if(prefix==0){
               prefix =1;
           }
       }

       int suffix = 1;
       int maxRight = Integer.MIN_VALUE;


       for(int i=nums.length-1;i>=0;i--){
           suffix = suffix * nums[i];
           maxRight = Math.max(maxRight,suffix);

           if(suffix==0){
               suffix =1;
           }
       }

      return Math.max(maxLeft, maxRight);
    } 
   
}