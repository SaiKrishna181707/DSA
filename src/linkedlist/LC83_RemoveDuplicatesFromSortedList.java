public class LC83_RemoveDuplicatesFromSortedList{
    // Definition for singly-linked list.
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

        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return head;
            }

            ListNode node = head;

            while (node.next != null) {

                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }

            return head;
        }
    }

    // Display method
    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public static void main(String[] args) {

        // Creating: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Before:");
        display(head);

        Solution solution = new Solution();
        head = solution.deleteDuplicates(head);

        System.out.println("After:");
        display(head);
    }
}
