/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

      if(root==null) return null;
       
       root.next = null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);

       while(!q.isEmpty()){

           int size = q.size();

           Node temp = q.poll();

            if(temp.left != null){
                    q.add(temp.left);
            }

            if(temp.right != null){
                    q.add(temp.right);
            }

           for(int i=0;i<size-1;i++){
               Node x = q.poll();
               temp.next = x;
                temp = x;

                if(x.left != null){
                    q.add(x.left);
                }

                if(x.right != null){
                    q.add(x.right);
                }
           }

           temp.next  = null;

       }

       return root;

        
    }
}