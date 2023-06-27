/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node curr = head;
        Node copy = new Node(Integer.MIN_VALUE);     //random value;
        Node currCopy = copy;

        HashMap<Node,Node> hmap  =new HashMap<>();
       
        while(curr != null){
            
            hmap.put(curr,new Node(curr.val));
            curr= curr.next;

        }

        curr = head;

        while(curr!= null){
           
           Node newCurr = hmap.get(curr);
            if(curr.next != null){
                newCurr.next = hmap.get(curr.next);
            }

            if(curr.random != null){
                newCurr.random = hmap.get(curr.random);
            }

            curr= curr.next;
        }

        return hmap.get(head);

     }
}