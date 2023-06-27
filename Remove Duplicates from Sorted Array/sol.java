class Solution {
    public int removeDuplicates(int[] nums) {

        HashSet<Integer> hset = new HashSet<>();
        hset.add(nums[0]);
        int index=1;
        for(int i=1;i<nums.length;i++){
            
            if(!hset.contains(nums[i])){
                hset.add(nums[i]);
                nums[index] =nums[i];
                index++;
            }
        }

        return hset.size();
        
    }
}