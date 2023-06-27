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

//not revesing the remaining 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

       if(head==null || head.next ==null){
           return head;
       }

       //find the kth node (end node)

       ListNode curr = head;
       int i =1;
       while(i<k){
          curr= curr.next;
          if(curr==null) return head;
          i++;
       }

       ListNode end = curr;
       ListNode start = head;

       ListNode restHead = reverseKGroup(end.next,k);
       reverse(start,end);
       start.next = restHead;

       return end;

    }
    static void reverse(ListNode start, ListNode end){

        ListNode prev = null;
        ListNode curr = start;

        while(prev != end){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    }
}