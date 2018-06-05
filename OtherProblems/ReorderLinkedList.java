package OtherProblems;

public class ReorderLinkedList {
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode newList = mid.next;
        mid.next = null;
        newList = reverse(newList);
        merge(head, newList);
        return head;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private void merge(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }

    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    private void listPrint(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderLinkedList solution = new ReorderLinkedList();
        ListNode head = new ListNode(1);
        ListNode runner = head;
        for (int i = 2; i <= 10; i++) {
            runner.next = new ListNode(i);
            runner = runner.next;
        }
        solution.reorder(head);
    }
}
