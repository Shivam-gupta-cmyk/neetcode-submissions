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

    public ListNode[] reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode []{prev,head};
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        ListNode ans = null;
        ListNode tail = null;
        ListNode nextNodeStart = null;
        for(int i=1;i<k;i++){
            if(secondPointer!=null) secondPointer = secondPointer.next;
            else return head;
            
        }
        if(secondPointer!=null){
            nextNodeStart = secondPointer.next;
            secondPointer.next = null;
        }
        ListNode[] temp = reverse(firstPointer);
        if(ans==null) head = temp[0];
        if(tail==null) tail = temp[1];
        boolean flag = false;
        while(secondPointer!=null){
            firstPointer = secondPointer = nextNodeStart;
            for(int i=1;i<k;i++){
                if(secondPointer==null) {
                    System.out.println(secondPointer);
                    flag = true;
                    break;
                }
                secondPointer = secondPointer.next;
                System.out.println(flag);
                
            }
            if(flag || secondPointer==null) break;
            System.out.println(flag);
            if(secondPointer!=null){
                nextNodeStart = secondPointer.next;
                secondPointer.next = null;
            }
            temp = reverse(firstPointer);
            tail.next = temp[0];
            tail = temp[1];
            
        }
        if(flag || secondPointer==null) tail.next = nextNodeStart;
        return head;
    }
}
