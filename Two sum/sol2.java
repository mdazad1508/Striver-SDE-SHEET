class Solution {

    class Pair{
        int index;
        int val;
        Pair(int a  , int  b){
            this.index = a;
            this.val =b;
        }
    }

    public int[] twoSum(int[] nums, int target) {

        //two pointers

        Pair[] arr  = new Pair[nums.length];

        for(int i=0;i<nums.length;i++){
            arr[i] = new Pair(i,nums[i]);
        }

        Arrays.sort(arr,(a,b)-> a.val-b.val);

        int low =0;
        int high = arr.length-1;

        while(low < high){

            if(arr[low].val+arr[high].val==target){
                return new int[]{arr[low].index,arr[high].index};
            }else if(arr[low].val+arr[high].val < target){
                low++;
            }else{
                high--;
            }
        }

        return new int[]{-1,-1};
      
    }
}