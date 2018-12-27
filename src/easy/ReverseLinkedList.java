package easy;


/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        return cur;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }
}
