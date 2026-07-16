public class LC92_ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            if (head == null || left == right) {
                return head;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode prev = dummy;
            ListNode current = head;

            // Move to the left position
            for (int i = 0; i < left - 1; i++) {
                prev = prev.next;
                current = current.next;
            }

            ListNode storing = current;
            ListNode fake = null;
            ListNode next = current.next;

            // Reverse the sublist
            for (int i = 0; i < right - left + 1; i++) {
                current.next = fake;
                fake = current;
                current = next;

                if (next != null) {
                    next = next.next;
                }
            }

            // Reconnect
            storing.next = current;
            prev.next = fake;

            return dummy.next;
        }
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(5)
                                )
                        )
                )
        );

        System.out.println("Original List:");
        printList(head);

        Solution solution = new Solution();

        head = solution.reverseBetween(head, 2, 4);

        System.out.println("After Reversing (2,4):");
        printList(head);
    }
}
