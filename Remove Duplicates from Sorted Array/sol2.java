class Solution {
    public int removeDuplicates(int[] nums) {

        
        int index=1;
        int prev = nums[0];
        //first element will always be there!
        for(int i=1;i<nums.length;i++){
            
            if(nums[i] != prev){
                nums[index] = nums[i];
                index++;
                prev = nums[i];
            }
        }

        return index;
        
    }
}