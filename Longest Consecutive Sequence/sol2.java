class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0) return 0;
        
       HashSet<Integer> hset = new HashSet<>() ;

       for(int i=0;i<nums.length;i++){
           hset.add(nums[i]);
       }

        int ans =1;
       Iterator<Integer> i = hset.iterator();

       while(i.hasNext()){
          int elem = i.next();
           if(!hset.contains(elem-1)){
               //it is the starting elemen
                int count =1;
               while(hset.contains(elem+1)){
                    count++;
                    elem = elem +1;
               }
               
               ans = Math.max(ans,count);
           }else{
               //it is not the starting element;
               continue;
           }
       }

       return ans;
      
    }
}