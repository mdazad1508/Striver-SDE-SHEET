/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head==null) return null;

        ListNode curr = head;
        int pos =0;

        HashMap<ListNode,Integer> hmap = new HashMap<>();

        while(curr.next!=null){

            if(!hmap.containsKey(curr)){
                hmap.put(curr,pos);
                curr=curr.next;
                pos++;
            }else{
                return curr;
            }

        }

        return null;
    }
}