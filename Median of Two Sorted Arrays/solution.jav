class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2){
          return  findMedianSortedArrays(nums2,nums1);  //ensuring that binary search happens on minimum size array
        }

        int leftHalfCount = (n1 + n2 + 1)/2;      //(partitionCount)  //works for both odd and even /
        //if array is merged and arranged sorted 
        //in case of even ,left half count and right half count are equal thus median is average of 
        //max element of left half and min element of right half;
        //in case of odd, left half count is one more than left half count thus median is max element 
        //left half ie that extra one;

        int low = 0 ;
        int high = nums1.length;

        //partioning (range from low to high)

        //cut at an index "cut" means left part from low to cut-1 and right part from cut to high;
        // if cut==0 means , no element in left part all are in right
        //if cut  = n1 , all element in left from 0 to n-1 , no element in right part
        // cut at index = 3 means there are 3 elements in left part from index 0 to 2;

        //cut1 = pationioning index in nums1;
        //cut 2 = partioning index in nums2;
        //cut1 + cut2 = leftHalfCount

        //left1 = at cut1-1;   right1 = at cut1;
        //left 2 = at cut2-1  right 2 = at cut2; 

        while(low <= high){

            int cut1  = (low + high)/2;
            int cut2 = leftHalfCount - cut1;
             
             int left1 = Integer.MIN_VALUE;
             int left2 = Integer.MIN_VALUE;

             if(cut1 != 0) left1 = nums1[cut1-1];
             if(cut2 != 0) left2 = nums2[cut2-1];

             int right1 = Integer.MAX_VALUE;
             int right2 = Integer.MAX_VALUE;

             if(cut1 !=n1) right1= nums1[cut1];
             if(cut2 !=n2) right2 = nums2[cut2];


            if(left1 <= right2 && left2 <= right1){
                //partioning is correct
                if( (n1+n2)%2 ==0){
                    //even 
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0f;
                }else{
                    //odd
                    return Math.max(left1,left2);
                }
            }else if(left1 >right2){
                //decrease left1        nums1 ka hi partioning karna hai, uske hisab se nums2 hojayega
                high = cut1-1;
            }else if(left2 > right1){
                //increase right 1
                low = cut1+1;
            }

        }
        return 0.0;
       
    }
}