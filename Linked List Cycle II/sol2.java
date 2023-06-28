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

        if(head==null || head.next ==null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next !=null){
            slow  =slow.next;
            fast = fast.next.next;

            if(slow==fast){
                break;
            }
        }

        if(fast.next==null || fast.next.next==null){
            //no collision 
            return null;
        }

        //now slow or fast pointer is the collision point , but it may not be the entry point as 
        //before colliding slow and fast make multiple rounds of the loop
        //, for finding the entry point we have to keep moving slow pointer and 
        //entry pointer simaltanoulsy till they collide, the point they will collide will be our 
        //entry point . they are bound to collide since there is a cycle


        ListNode entry = head;

        while(entry != slow){
            entry = entry.next;
            slow =slow.next;
        }

        return entry;

       
    }
}