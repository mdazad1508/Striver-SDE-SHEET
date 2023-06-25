//using merge Sort

import java.util.* ;
import java.io.*; 
public class Solution {
    static int ans;
    public static long getInversions(long arr[], int n) {
        
        int start =0;
        int end = arr.length-1;
      
       mergeSort(start,end,arr);
       return ans;
        
    }

    static void mergeSort(int start, int end , long[] arr){

        if(start == end){
          return;
        }

        int mid = (start+end)/2;

        mergeSort(start,mid,arr);
        mergeSort(mid+1,end,arr);

        merge(start,mid,end,arr);

    }
    static void merge(int start, int mid ,int end, long[]arr){

        int l1 = start;
        int h1 = mid;
        int l2 = mid+1;
        int h2 = end;

        long [] temp = new long[end-start+1];
        int idx=0;

        int count=0;

        while(l1<=h1 || l2 <=h2){

            long x1 = l1<=h1 ? arr[l1] : Long.MAX_VALUE;
            long x2 = l2<=h2 ? arr[l2] : Long.MAX_VALUE;

            if(x1<=x2){
               temp[idx]=x1;
               idx++;
               l1++;
            }else{
                count+= h1-l1+1;
                temp[idx] =x2;
                idx++;
                l2++;
            }
        }

        for(int i=0;i<temp.length;i++){
            arr[i+start] = temp[i];
        }

        ans += count;
    }
}