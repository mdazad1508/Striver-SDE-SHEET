


class Solution {
     int ans;      //not static important 
    public int reversePairs(int[] nums) {
       long [] arr = new long[nums.length];
       for(int i=0;i<nums.length;i++){
           arr[i] = nums[i];
       }

       //converting int array to long array because comparision ho raha hai and maxInt *2 will cross int range
       // also if arr[i] = maxInt , then  for i > range else case will also be Integer.MAX_VALUE;
       mergeSort(0,nums.length-1,arr);
       return ans;
        
    }
     void mergeSort(int start, int end, long [] nums){
        
        if(start ==end){
            return;
        }

        int mid = (start+end)/2;

        mergeSort(start,mid,nums);
        mergeSort(mid+1,end,nums);
          
        countPairs(start,mid,end,nums);
        merge(start,mid,end,nums);
    }
     void merge(int start, int mid,int end,long[]nums){
    
        int l1 = start;
        int h1 = mid;
        int l2 = mid+1;
        int h2 = end;

        long [] temp = new long[ end- start + 1];

        int index = 0;
        while(l1 <= h1 || l2 <= h2){

            long x1 = l1<=h1 ? nums[l1] : Long.MAX_VALUE;
            long x2 = l2<=h2 ? nums[l2] :Long.MAX_VALUE;

            if(x1<=x2){
                temp[index] = x1;
                index++;
                l1++;
            }else{
                temp[index] = x2;
                index++;
                l2++; 
            }
        }

        for(int k=0;k<temp.length;k++){
            nums[start+k] = temp[k];
        }
    }
     void countPairs(int start,int mid,int end,long[]nums){

      
        int count =0;
        int right = mid+1;

        for(int i=start;i<=mid;i++){
             

            while(right <= end && nums[i]> 2* nums[right]){
                right++;
            }

            count += right-(mid+1);
        }

        ans += count;
    }
}