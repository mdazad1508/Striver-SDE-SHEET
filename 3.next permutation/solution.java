class Solution {
    public void nextPermutation(int[] nums) {


        int dipIndex = -1;

        for(int i= nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                dipIndex =i;
                break;
            }
        }

        if(dipIndex == -1){
            //no dip , its already the largest permutation, reversing it will give answer;
            reverse(nums,0,nums.length-1);
            return;
        }

        //since dip index is found, and from n-1 to dip index elements are in increasing order ,
        // therefore we must swap dip index with someone which is greater than dip index but closer to it

        //[2,1,5,4,3,0,0]
        //dip index at 1 , and 5,4,3 > 1 so will swap with 3 
        //[2,3,5,4,1,0,0]
        // now after dip index elements are still in increasing order so if we reverse the array 
        //after dipIndex we will get smallest number as well as next permutation


        for(int i=nums.length-1;i>dipIndex;i--){
            if(nums[i]>nums[dipIndex]){
                swap(nums,dipIndex,i);
                break;
            }
        }

        reverse(nums,dipIndex+1,nums.length-1);

    }

    static void reverse(int [] arr, int start ,int end){

        while(start<=end){
            swap(arr,start,end);
            end--;
            start++;
        }  

    }

    static void swap(int [] arr, int a , int b){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
}