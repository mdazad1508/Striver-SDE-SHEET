class Solution {
    public void sortColors(int[] nums) {
         

         //Dutch Nation flag Algorithm;

         int low =0;
         int mid =0;
         int high = nums.length-1;

         while(mid <= high){

             if(nums[mid]==0){
                 swap(nums,mid,low);
                 low++;
                 mid++;

             }else if(nums[mid]==2){
                  swap(nums,mid,high);
                  high--;
                 
             }else{
                 mid++;
             }
         }


    }
    static void swap(int [] arr, int a , int b){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
}