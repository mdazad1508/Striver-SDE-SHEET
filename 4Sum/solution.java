class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    
        Arrays.sort(nums);
        HashSet<List<Integer>> hset = new HashSet<>();


        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                int first = i;          //fixed
                int second = j;         //fixed 
                int third =  j+1;
                int fourth = nums.length-1;


                while(third < fourth){
                   
                long sum = (long)nums[first]+ (long)nums[second] + (long)nums[third] + (long)nums[fourth];

                   if(sum==target){
                       List<Integer> list = new ArrayList<>();
                       list.add(nums[first]);
                       list.add(nums[second]);
                       list.add(nums[third]);
                       list.add(nums[fourth]);
                       hset.add(list);

                       third++;
                       fourth--;
                   }else if(sum <target){
                       third++;
                   }else{
                       fourth--;
                   }
                    
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(hset);
        return ans;

    }
}