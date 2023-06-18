class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return build(0,nums.length-1,nums);
        
    }

    static TreeNode build(int low , int high, int []arr){
       
       TreeNode root = null;

       if(low <= high){
          int mid = (low+high)/2;
          root = new TreeNode(arr[mid]);

          root.left = build(low,mid-1,arr);
          root.right = build(mid+1,high,arr);
       }

       return root;
       
    }
}