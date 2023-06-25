class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

     int p1 =0;
     int p2 = 0;
     int index =0;

     int [] num1Copy = nums1.clone();
    
     int l2 = nums2.length;
     int l1 = nums1.length-nums2.length;

     while(p1 < l1 || p2 < l2){

         int x1 =p1<l1 ? num1Copy[p1] :Integer.MAX_VALUE;
         int x2 =p2 < l2 ? nums2[p2] : Integer.MAX_VALUE;

         if(x1 <= x2){
             nums1[index]= x1;
             index++;
             p1++;
         }else{
             nums1[index] = x2;
             index++;
             p2++;
         }
     }
      
    }
}