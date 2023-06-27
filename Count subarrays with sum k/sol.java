class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> hmap = new HashMap<>();
         
        int count =0;
        int sum =0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(sum==k){
                count++;
            }
            int rem = sum -k;

            if(hmap.containsKey(rem)){
                    count += hmap.get(rem);
            }
            

           if(hmap.containsKey(sum)){
               hmap.put(sum,hmap.get(sum)+1);
           }else{
               hmap.put(sum,1);
           } 
        }

        return count;
    }
}