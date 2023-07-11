class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     
        int []ans = new int[nums.length-k+1];
        Deque<Integer> q  = new LinkedList<>();

         int i=0;
         int j=0;


         while(j<nums.length){
            
           if(q.isEmpty()){
               q.addLast(nums[j]);
           }else{
               //remove all the elments which are smallers than nums[j] from queue becasue they will hold no 
               //signifiace in future

               while(!q.isEmpty() && q.peekLast()<nums[j]){
                   q.pollLast();
               }

               q.addLast(nums[j]);
           }

            int windowSize = j-i+1;

            if(windowSize<k){
                j++;
            }else if(windowSize==k){
                 
              ans[i] = q.peekFirst();

              if(nums[i]==q.peekFirst()){
                  //you better remove it;
                  q.pollFirst();
              }

              i++;
              j++;


            }

         }

         return ans;

    }
   
}