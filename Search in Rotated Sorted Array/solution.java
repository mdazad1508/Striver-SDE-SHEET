class Solution {
    public int search(int[] nums, int target) {
      
    //property of roatated sorted array : at any index , one part is always sorted

     int low =0 ;
     int high = nums.length -1;

     while(low <=high){

         int mid = (low + high)/2;
         
         if(nums[mid]==target){
             return mid;
         }

         if(nums[low] <= nums[mid]){
             //left half is sorted

             if(target>= nums[low] && target<=nums[mid]){
                 high = mid;
             }else{
                 low = mid+1;
             }
         }else if(nums[mid+1] <= nums[high]){

             //right half is sorted;

             if(target>= nums[mid+1] && target<=nums[high]){
                 low = mid+1;
             }else{
                 high = mid;
             }

         }


     }

     return -1;

        
    }

   
}