
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root ==null) return null;

        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
        
    }

   }




   //solution 2:

   

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //idea is like i will add paths of these nodes in two array list , and will check is one list LCA is 
        //present in other's list from end..
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        path(root,p.val,list1);
        path(root,q.val,list2);

        for(int i = list1.size()-1;i>=0;i--){
            if(list2.contains(list1.get(i))){
                return list1.get(i);
            }
        }

        return null;
        
    }

    static void path(TreeNode root, int x,ArrayList<TreeNode> list){

        TreeNode curr = root;

        while(curr.val != x){

            if(x<curr.val){
                list.add(curr);
                curr= curr.left;
            }else{
                list.add(curr);
                curr= curr.right;
            }
        }

        list.add(curr);
    }
}