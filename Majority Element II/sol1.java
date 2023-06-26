class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hmap =new HashMap<>();

        for(int i=0;i<nums.length;i++){

            if(!hmap.containsKey(nums[i])){
                hmap.put(nums[i],1);
            }else{
                hmap.put(nums[i],hmap.get(nums[i])+1);
            }
        }


      for( Map.Entry<Integer,Integer> e : hmap.entrySet()){
          if(e.getValue()>nums.length/3){
              list.add(e.getKey());
          }
      }

      return list;
        
    }
}