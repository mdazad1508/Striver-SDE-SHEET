class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //Hashing ans 2 pointer (1 fixed)

        Arrays.sort(nums);

       HashSet<List<Integer>> ans  = new HashSet<>();


        for(int i=0;i<nums.length;i++){

            int first = i ;                      //fixed (will not move)
            int second = i+1;           
            int third = nums.length-1;


            while(second < third){

                if(nums[first]+nums[second]+nums[third]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                    second++;
                    third--;
                }else if(nums[first]+nums[second]+nums[third]<0){
                    second++;
                }else{
                    third--;
                }
            }

           
        }

        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
        
   
     }
}