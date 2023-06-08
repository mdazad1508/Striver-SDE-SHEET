class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       HashSet<List<Integer>> ans =new HashSet<>();
       fun(0,candidates,target,ans,new ArrayList<>());

       List<List<Integer>> fans = new ArrayList<>(ans);
       return fans;

       
    }

    static void fun(int index , int[] nums ,int target, HashSet<List<Integer>> ans, List<Integer> list){

        if(target==0){
            ans.add(new ArrayList<>(list));  
            return;
        }

        for(int i=index;i<nums.length;i++){

            if(i>index && nums[i]==nums[i-1]) continue;
            if(nums[index] > target) break;
            

            list.add(nums[i]);
            fun(i+1,nums,target-nums[i],ans,list);
            list.remove(list.size()-1);
        }

       

    }
}