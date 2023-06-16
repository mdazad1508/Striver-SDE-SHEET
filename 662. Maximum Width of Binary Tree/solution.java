



class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
      
        indexing(root,0);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int ans = 0;

        while(!q.isEmpty()){
            
            int size = q.size();
            int first = 0;
            int last = 0;

            for(int i=0;i<size;i++){

                TreeNode curr = q.poll();

                if(i==0){
                    first = curr.val;
                }

                if(i==size-1){
                    last = curr.val;
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            ans = Math.max(ans,last-first +1);

        }
        return ans;
        
    }

    static void indexing(TreeNode root, int index){

        if(root==null){
            return;
        }

        root.val = index;
        
        indexing(root.left,2*index + 1);
        indexing(root.right,2*index +2);
    


    }
}








//bit lengthy... 




class Solution {
    static class Pair{
        int index;
        TreeNode node;
        Pair(int index,TreeNode node){
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        int ans =0;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            int first = 0;
            int last =0;

            int minIndex = q.peek().index;
            int size = q.size();

            for(int i=0;i<size;i++){
                
                int currIndex = q.peek().index -minIndex; //normalizing index to avoid memory overflow
                TreeNode curr = q.poll().node;

                if(i==0) first = currIndex;
                if(i==size-1) last = currIndex;
                
                if(curr.left != null){
                    q.add(new Pair(2*currIndex +1,curr.left));
                }

                if(curr.right != null){
                    q.add(new Pair(2*currIndex +2,curr.right));
                }
            }

            ans = Math.max(ans,last-first +1);
        }

        return ans;


    }
}