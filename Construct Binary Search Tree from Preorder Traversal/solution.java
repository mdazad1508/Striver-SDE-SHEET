class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = null;

        for(int i=0;i<preorder.length;i++){

          root =  build(root,preorder[i]);

        }

        return root;
        
    }
    static TreeNode build(TreeNode root, int val){

        if(root ==null){
            return new TreeNode(val);
        }

        if(val < root.val){
            root.left = build(root.left,val);
        }

        if(val > root.val){
            root.right = build(root.right,val);
        }

        return root;
    }
}