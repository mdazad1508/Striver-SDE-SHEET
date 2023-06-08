public class Solution {
    public int findMedian(int[][] A) {
        
        int n = A.length;
        int m = A[0].length;
        
        int medianPosition = (n*m)/2;   // = totallengthOfArray/2 comparision issi se hoga count ka
        
        int low = 1;
        int high = (int)10e9;
        
        
        while(low<=high){
            int mid = (low+high)/2;
            
            int count =0;
            for(int i=0;i<A.length;i++){
                count += countLessThanEqualToMid(A[i],mid);
            }
            
            if(count <= medianPosition) low = mid+1;
            else high = mid-1;
        }
        
        return low;  
        
    }
    static int countLessThanEqualToMid(int [] arr, int x){
        
        int low =0;
        int high = arr.length -1;
        
        while(low<=high){
            
            int mid = (low+high)/2;
            
            if(arr[mid] <= x){
                low  = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        
        return low;
    }
}   