/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        ArrayList<Integer> list =new ArrayList<>();
        dfs(head,list);

        Node ans = new Node(5);
        Node curr = ans;
        Node previous = null;

        for(int i=0;i<list.size();i++){
            curr.next = new Node(list.get(i));
            curr.next.prev = previous;
            previous = curr.next;
            curr = curr.next;
        }

        return ans.next;
        
    }

    static void dfs(Node root, ArrayList<Integer> list){

        if(root==null ){
            return;
        }

        Node curr= root;
        

        while(curr.child ==null && curr.next != null){
            list.add(curr.val);
            curr = curr.next;
        }

        Node next1 = curr.next;
        list.add(curr.val);
        
        dfs(curr.child,list);

        while(next1 != null){
            list.add(next1.val);
            next1 = next1.next;
        }

    }
}