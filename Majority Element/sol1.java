class Solution {
    public int majorityElement(int[] nums) {
        //moore's voting algorithm'

        int majority = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++){

            if(count==0){
                majority = i;  //i might be your majority;
                count++;
            }else if(nums[i]==nums[majority]){
                count++;
            }else{
                count--;
            }
        }

        return nums[majority];
    }
}