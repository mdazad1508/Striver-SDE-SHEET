/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val;}
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

      //find the middle of linkedList ;

      ListNode slow = head;   
      ListNode fast = head;

      //slow moves 1 step at a time
      //fast moves 2 steps at a time

       while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }

       //slow is the middle 

       slow.next = reverse(slow.next);

       slow = slow.next; //for right half 

       ListNode start = head;

       while(slow != null){

           if(start.val != slow.val){
               return false;
           }

           slow =slow.next;
           start =start.next;
       }

       return true;

  
    }
    static ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next =prev;
            prev = curr;
            curr =next;
        }

        return prev;
    }
}