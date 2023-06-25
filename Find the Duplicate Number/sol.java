class Solution {
    public int findDuplicate(int[] nums) {
     
     // 0(n) space + 0(n) time 

     boolean [] present = new boolean[nums.length+1];

     for(int i=0;i<nums.length;i++){

         if(!present[nums[i]]){
             present[nums[i]] =true;
         }else{
             return nums[i];
         }
     }

     return -1;
        
    }
}