import java.util.*;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        
        Arrays.sort(stalls);
        if(k>stalls.length){
            return -1;
        }

        int high = stalls[stalls.length-1] - stalls[0];
        int low = stalls[1]-stalls[0];; // ek ke bagal me ek baithe hai 
        int res = low;


        while(low <= high){

            int mid = (low + high)/2;

            if(isAllocatingCowsPossible(stalls,k,mid)){
                res = mid;
                low = mid+1; 
            }else{
               high = mid-1;  
                
            }
        }

        return res;

    }
    static boolean isAllocatingCowsPossible(int [] arr, int k ,int mid){

        //agar minimum distance mid ka rakhte hai to kya possible hai ...
        //distance agar minimun se thoda jyda ho jayega to chalega
        //more cows with this minimun distance is not a problem , we can remove rest cows
        int start = arr[0];
        int cowCount = 1;
        for(int i=1;i<arr.length;i++){
            
            //if(arr[i] - start > mid ) return false;

            if(arr[i]-start < mid){
                 continue;
            }else{
              start = arr[i];
              cowCount++;
            } 
            
        }


        if(cowCount < k) return false;
        return true;

    }
    static int max(int [] arr){
          int max = Integer.MIN_VALUE;

          for(int i=0;i<arr.length;i++){
              if(arr[i]>=max){
                  max = arr[i];
              }
          }
          return max;
    }
    static int min(int [] arr){
          int min = Integer.MAX_VALUE;

          for(int i=0;i<arr.length;i++){
              if(arr[i]<=min){
                  min = arr[i];
              }
          }
          return min;
    }
}