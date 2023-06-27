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
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next ==null){
            return head;
        }

        int x = k % length(head);

        ListNode curr =head;

        for(int i=0;i<x;i++){
            curr = rotate(curr);
        }

        return curr;
        
    }
    static ListNode rotate(ListNode root){

        ListNode curr =root;

        while(curr.next.next != null){
            curr = curr.next;
        }

        ListNode last = curr.next;
        curr.next = null;
        last.next = root;

        return last;
    }
    static int length(ListNode root){
        int len =0;
        ListNode curr =root;
        while(curr != null){
            len++;
            curr =curr.next;
        }
        return len;
    }

}