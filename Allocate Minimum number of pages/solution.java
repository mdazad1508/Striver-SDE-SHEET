public class Solution {
    public int books(int[] A, int B) {
        
       if(B> A.length){
           return -1;
       }
        
       int res = -1;
       int low = min(A);      //minimun max page one can get if B = A.length
       int high = sum(A);     // maximun  max page one can get  if B =1;
       
       while(low <= high){
           
           int mid = (low + high)/2 ;  //barrier 
           
           if(isAllocationPossible(mid , A, B)){
               res = mid;
               high = mid-1;         //minimun nikal rahe hai 
           }else{
               low = mid+1;
           }
           
       }
       
       return res;
        
    }
    static int sum(int [] arr){
        int ans =0;
        
        for(int i=0;i<arr.length;i++){
            ans += arr[i];
        }
        return ans;
    }
    
    static boolean isAllocationPossible(int mid , int []arr, int student ){
        
        //mid maximum hai , mtlb ussey kam bhi rahega to chalega
        //means if student = 3 , we are allocating to 2 students , which means we could allocated the same to 3 students also ,
        // suppose mid = 213 so maximum Book one can have is 213  therefore i can allocate [12,34,67,90] to 1 student also , every element is less than 213 so we can allocated same to more number of students na
        //so less ALLOCATED student is  is not a problem
        
        
        int AllocatedStudent =0;
        
        int page =0;
        for(int i=0;i<arr.length;i++){
            
            if(arr[i] > mid) return false;
            
            if(page + arr[i] > mid){
                AllocatedStudent ++;
                page = arr[i];
            }else{
                page += arr[i];
            }
            
        } 
        
        if(page <= mid) {
            AllocatedStudent++;
        }
        
        if(AllocatedStudent <= student){
            return true;
        }
        return false;
        
        
    }
    
    static int min(int [] arr){
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        
        return min;
    }
    
}
