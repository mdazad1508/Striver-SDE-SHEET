class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        fun(0,candidates,target,ans,new ArrayList<>());
        return ans;

    }
    static void fun(int index, int [] arr, int target,List<List<Integer>> ans, List<Integer> list){
         
         if(target <0){
             return;
         }

        if(target==0){
            if(!ans.contains(new ArrayList<>(list))){
               ans.add(new ArrayList<>(list));
            } 
            return;
        }

        if(index == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }

            return;
        }
          //pick the element and move to next
          list.add(arr[index]);
          fun(index+1,arr,target-arr[index],ans,list);

          //pick the element and stay there (for getting picked up again)
          fun(index,arr,target-arr[index],ans,list);

          //don't pick the element'
        
        list.remove(list.size()-1);
        fun(index + 1, arr, target , ans,list);


    }
     
}