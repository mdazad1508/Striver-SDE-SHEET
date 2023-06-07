class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      
      Arrays.sort(nums);

    List<List<Integer>> ans = new ArrayList<>();

        fun(0,nums,new ArrayList<>(),ans);
        return ans;
    
     
    }
    static void fun(int index, int [] nums, List<Integer> list , List<List<Integer>> ans){

        if(index ==nums.length){
            if(ans.contains(new ArrayList<>(list))){
                return;
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        //pick 
         
         list.add(nums[index]);
         fun(index+1,nums,list,ans);

         //not pick;
         list.remove(list.size()-1);
         fun(index+1,nums,list,ans);
    }
}