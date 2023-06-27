
 //CODE FOR ALSO REVERSING THE REMAINING WHICH are less than K;
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

       if(head==null || head.next ==null){
           return head;
       }

       //find the kth node (end node)

       ListNode curr = head;
       int i =1;
       while(i<k && curr.next != null){
          curr= curr.next;
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