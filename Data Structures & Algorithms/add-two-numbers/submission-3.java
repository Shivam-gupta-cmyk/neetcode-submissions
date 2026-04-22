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

//  9 
//  9 
//  8 1
//  1 8

//  1 2 3
//  4 5 6
//  9 7 5

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;
        while(node1!=null || node2!=null){
            int val1 = node1!=null?node1.val:0;
            int val2 = node2!=null?node2.val:0;
            int sum = val1+val2+carry;
            int rem = sum%10;
            carry = sum/10;
            ListNode tempNode = new ListNode(rem);
            if(head==null) head= tempNode;
            if(curr==null)curr= tempNode;
            else{
                curr.next = tempNode;
                curr = curr.next;
            }
            if(node1!=null)node1 = node1.next;
            if(node2!=null)node2 = node2.next;
        }
        if(carry==1){
            curr.next= new ListNode(1);
        }
        return head;
    }
}
