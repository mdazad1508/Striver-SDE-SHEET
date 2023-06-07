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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
         ListNode curr1 = list1;
         ListNode curr2 = list2;

         ListNode head = new ListNode(1);
         ListNode curr = head;

         while(curr1 != null || curr2 !=null){
            int v1 = Integer.MAX_VALUE;
            int v2 = Integer.MAX_VALUE;

            if(curr1 !=null){
                v1 = curr1.val;
            }

            if(curr2 != null){
                v2 = curr2.val;
            }

            if(v1 <= v2){
                 curr.next = new ListNode(v1);
                 curr = curr.next;
                 curr1 = curr1.next;
            }else{
                curr.next = new ListNode(v2);
                 curr = curr.next;
                 curr2 = curr2.next;
            }

         }

         return head.next;
        
    }
}