public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        fun(root,x,list,ans);
        return ans;

    }
    static void fun(TreeNode root, int x , ArrayList<Integer> list,ArrayList<Integer> ans){
         
        if(root==null){
           return;
        }
        
        if(root.data ==x){
            list.add(root.data);
            
            for(int i=0;i<list.size();i++){
                ans.add(list.get(i));
            }
            return;
        }


        list.add(root.data);
        fun(root.left,x,list,ans);
        fun(root.right,x,list,ans);
        list.remove(list.size()-1);
    }
}