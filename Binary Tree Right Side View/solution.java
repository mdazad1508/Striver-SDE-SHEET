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






//level order traversal 

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ds = new ArrayList<>();
        if(root==null) return ds;
        fun(root,ds);
        return ds;
    }

    static void fun(TreeNode root, List<Integer> ds){
           
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i=0;i<count;i++){
                
               TreeNode curr = q.poll();
               if(i==0){
                   ds.add(curr.val);
               }
               //first add righ then left 
               // or you can do , add when i==count -1
                if(curr.right != null){
                    q.add(curr.right);
                }
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                
            }
        }
        

    }
}