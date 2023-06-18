class Solution {
    public boolean isValidBST(TreeNode root) {

       //inorder traversal of bst is always sorted in ascending order;

       ArrayList<Integer> list = new ArrayList<>();
       inorder(root,list);

       for(int i=1;i<list.size();i++){
           if(list.get(i)<=list.get(i-1)){
               return false;
           }
       }

       return true;
        
    }
    static void inorder(TreeNode root,ArrayList<Integer> list){

        if(root==null){
            return;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}