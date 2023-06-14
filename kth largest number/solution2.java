class Solution {
    public int findKthLargest(int[] nums, int k) {

        //quickSelect;
        return quickSelect(nums,0,nums.length-1,k,nums.length);
      
    }
    static int quickSelect(int [] nums,int low ,int high,int k,int n){
        
        
        int partitionIndex = partition(nums,low,high);
        //nth largest position : n-partitionIndex 
        int nthLargest = n - partitionIndex ;

        if(nthLargest < k){
             return quickSelect(nums,low,partitionIndex-1,k,n);
        }else if(nthLargest > k){
             return quickSelect(nums,partitionIndex+1,high,k,n);
        }else{
            return nums[partitionIndex];
        }
       
    }
    static int partition(int [] arr,int low , int high){
            
        int pivot = arr[high];
        
        int i = low;
        int j= low;
        
        while(i <=high ){
           if( arr[i]<=pivot){
               swap(arr,i,j);
               i++;
               j++;
           }else{
               i++;
           }
        }
       
        return j-1;  
    }
     static void swap(int [] arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}