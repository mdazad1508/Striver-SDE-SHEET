/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        // preorder reverse traversal since it is for right side
        // ie. root , right , left;

        //idea is that whenever my datastructure size is equal to level,
        //it means we are encountring the element first time from right side view
        
        List<Integer> ds = new ArrayList<>();
        fun(root,0,ds);
        return ds;
    }

    static void fun(TreeNode root, int level , List<Integer> ds){
           
           if(root==null){
               return;
           }

           if(level == ds.size()){
               ds.add(root.val);
           }

           fun(root.right,level+1,ds);
           fun(root.left,level+1,ds);

    }
}