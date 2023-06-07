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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size =0;

        ListNode curr = head;

        while(curr != null){
            size++;
            curr = curr.next;
        }

        if(size ==1 && n==1){
            return null;
        }
         
        if(n>size){
            return head;
        }
       
        int pos = size - n +1;


        if(pos==1){
            return head.next;
        }

        curr =head;
        int i =1;

        while(  i < pos-1 && curr != null ){

            curr = curr.next;
            i++;
        }
            
        curr.next = curr.next.next;

        return head;


     
    }
}