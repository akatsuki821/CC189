package OtherProblems;

public class SelectionSortLinkedList {

     static class ListNode {
         public int value;
         public ListNode next;

         public ListNode(int value) {
             this.value = value;
             next = null;
         }
     }

    public static ListNode selectionSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode anchor = head;
        ListNode anchorPrev = dummy;
        while (anchor != null) {
            //print(dummy);
            ListNode runner = anchor;
            ListNode min = anchor;
            ListNode prev = anchorPrev;
            ListNode minPrev = prev;
            while (runner != null) {
                if (runner.value < min.value) {
                    min = runner;
                    minPrev = prev;
                }
                prev = runner;
                runner = runner.next;
            }
            swap(anchorPrev, anchor, minPrev, min);
            anchorPrev = anchorPrev.next;
            anchor = anchorPrev.next;
        }
        return dummy.next;
    }

    private static void swap(ListNode anchorPrev, ListNode anchor, ListNode minPrev, ListNode min) {
        //the two special cases should be taken care individually
        if (anchor == min) {
            return;
        }
        if (anchor == minPrev) {
            ListNode minNext = min.next;
            anchorPrev.next = min;
            min.next = anchor;
            anchor.next = minNext;
            return;
        }
        ListNode next = anchor.next;
        ListNode minNext = min.next;
        anchorPrev.next = min;
        min.next = next;
        minPrev.next = anchor;
        anchor.next = minNext;
    }
    private static void print(ListNode node) {
         while (node != null) {
             System.out.print(node.value + " ");
             node = node.next;
         }
         System.out.println();
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        selectionSort(l1);

    }
}
