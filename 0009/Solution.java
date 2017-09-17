public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
        }

        ListNode curr = head.next;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            if (curr != null) {
                curr.next = l1;
            } else {
                curr = l1;
            }
        }

        if (l2 != null) {
            if (curr != null) {
                curr.next = l2;
            } else {
                curr = l2;
            }
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void runTest() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode results = mergeTwoLists(a, b);
        System.out.print(results.val + " ");
        while (results.next != null) {
            results = results.next;
            System.out.print(results.val + " ");
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.runTest();

    }
}
