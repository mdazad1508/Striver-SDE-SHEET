

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        if(n>m){
            return kthElement(arr2,arr1,m,n,k);
            //apply binary search on smallest array;
        }
        
      //binarySearch
      
      //merge median sort me we were partioning at leftHalfCount ie (n1 + n2 +1)/2;
      
      //if i partition at k elements , then max(left1,left2) would be answer;
      
      int partionCount = k;  //like before patition there must be 3 elements,i want to pick those 
     //               those 3 elements from both array and the max(left1,left2) would be my answer
     
     int low = Math.max(0,k-m);    //vvi
     int high = Math.min(k,n);     //vvi 
     
     
     while(low<=high){
         
         int cut1 = (low +high)/2;
         int cut2  = partionCount - cut1;
         
         
         int left1 = (cut1==0)?Integer.MIN_VALUE:arr1[cut1-1];
         int left2 = (cut2==0)?Integer.MIN_VALUE:arr2[cut2-1];
         
         int right1 = (cut1 == n)?Integer.MAX_VALUE:arr1[cut1];
         int right2 = (cut2 == m)?Integer.MAX_VALUE:arr2[cut2];
         
         
         
         
         if(left1 <= right2 && left2 <= right1){
             //pationing is correct (sorted merged array)
             
             return Math.max(left1,left2);
         }else if(left1 > right2){
             
             high = cut1-1;
         }else if(left2 > right1){
             low = cut1 +1;
         }
         
     }
     
     return -1;
        
        
    }
}