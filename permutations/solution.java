class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        fun(0,nums,ans,new ArrayList<>(),new HashSet<>());
        return ans;

        
    }
    static void fun(int index,int []nums,List<List<Integer>> ans,List<Integer> list,HashSet<Integer> hset){

      
         if(index ==nums.length){
             ans.add(new ArrayList<>(list));
             return;
         }

        
        for(int i=0;i<nums.length;i++){

            if(hset.contains(i)) continue;
              
             list.add(nums[i]);
             hset.add(i);
             fun(index+1,nums,ans,list,hset);
             list.remove(list.size()-1);
             hset.remove(i);

        }


    }
}