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
    // 2 4 6 8 10

    // 2  4 6  8 10 12
    // 2 12 4 10 6 8
    // 2 4 6
    // 8 10 12
    // 2  4 6 
    // 10 8
    // 2 - 10 - 4 -  8 - 6 --1 
    //   8 10 12 14

    //   8  10
    //   10 12
    //   12 null
    
    // 12  10
    // 10 8
    // 8 null;

    //   prevNode = null
    //   currNode = head;
    //   nextNode ;
    //   preVode = currNode;


//    2 4  6 8 10
//    2 4 6
//    8 10



    public void reorderList(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head; 
        while(fastNode!=null && fastNode.next!=null && fastNode.next.next!=null){
            slowNode= slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode newNode = slowNode.next;
        slowNode.next = null;
        ListNode prev=null;
        ListNode curr = newNode;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }

        ListNode temp = head;
        ListNode tempNode2 = prev;
        while(tempNode2!=null){
            ListNode pointerNode = temp.next;
            ListNode pointerNode2 = tempNode2.next;
            temp.next = tempNode2;
            tempNode2.next = pointerNode;
            temp = pointerNode;
            tempNode2 = pointerNode2;



//   2   4 
//   8   6

            // secondListNext = newNode.next;
            // newNode.next = pointerNode;
            // temp = pointerNode;
        }

    }
}
