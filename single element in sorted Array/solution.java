class Solution {
    public int singleNonDuplicate(int[] nums) {
       
       int low = 0;
       int high = nums.length -1;
       if(nums.length==1) return nums[0];


       while(low<=high){

           int mid = (low + high)/2;

           if(mid==0 && nums[mid] != nums[mid+1]) return nums[mid];
           if(mid ==nums.length-1 && nums[mid] != nums[mid-1]) return nums[mid];



           if(nums[mid]==nums[mid-1]){
                
                int leftCount = mid-1 +1;  //including mid-1

               if((leftCount) %2 ==0){
                   //extra element in left
                   high = mid-2;
               }else{
                   low = mid+1;
               }
              
           }else if(nums[mid]==nums[mid+1]){
                int rightCount = nums.length-1 -mid ;  //including mid+1
                
                if(rightCount %2 ==0){
                    //extra element in right;
                    low = mid +2;
                }else{
                    //no extra element in right;
                    high = mid-1;
                }

           }else{
               return nums[mid];
           }
          
       }

       return -1;
        
    }
}