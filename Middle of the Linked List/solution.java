/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {

        int size = 0;

        ListNode curr = head;

        while(curr != null){
            size++;
            curr = curr.next;
        }


        int i=0;

        curr = head;

        while(i != size/2){
            curr = curr.next;
            i++;
        }

        return curr;
        
    }
}