package easy.list;


/**
 * Given a linked list, delete the nth to mth nodes in the linked list, and return the head node of the linked list.
 *
 * Example
 * Give linked list 1->2->3->4->5->null,n=1',m=2, return 1->4->5->null
 *
 * Give linked list 1->2->3->4->5->null,n=1',m=4, return 1->null
 */
public class DeleteNode {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printListNode(node1);
        new DeleteNode().deleteNode(node1, 1, 2);
        printListNode(node1);

    }
    /**
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public ListNode deleteNode(ListNode head, int n, int m) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode headBefore = new ListNode(0);
        headBefore.next = head;
        ListNode start = headBefore;
        for (int i = 0; i < n; i++) {
            start = start.next;
        }
        ListNode end = start.next;
        for (int j = 0; j < m - n + 1; j++) {
            if (end == null) {
                break;
            }
            end = end.next;
        }
        start.next = end;
        return headBefore.next;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }

}
