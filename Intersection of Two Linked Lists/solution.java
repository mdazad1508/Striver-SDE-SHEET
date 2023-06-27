public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA ==null || headB== null){
            return null;
        }

        HashSet<ListNode> hset = new HashSet<>();

        ListNode curr = headA;

        while(curr != null){
             hset.add(curr);
             curr= curr.next;
        }

        curr = headB;

        while(curr!= null){
            
            if(hset.contains(curr)){
                return curr;
            }

            curr=curr.next;
        }

        return null;
        
    }
}