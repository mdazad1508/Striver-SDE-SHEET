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
    public boolean isPalindrome(ListNode head) {

        //naive sol (put all in array list and check if its paridrome or not )

        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){
            list.add(curr.val);
            curr =curr.next;
        }

        return palidromeCheck(list);
        
    }
    static boolean palidromeCheck(ArrayList<Integer> list){

        int left = 0;
        int right = list.size()-1;

        while(left < right){

            if(list.get(left) != list.get(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }

        return true;
    }
}