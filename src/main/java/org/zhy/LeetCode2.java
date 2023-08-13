package org.zhy;

public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int current;
        int carry = 0;

        ListNode tmp = null;
        ListNode result = null;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            current = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            if (tmp == null) {
                tmp = new ListNode(current);
                result = tmp;
            } else {
                tmp.next = new ListNode(current);
                tmp = tmp.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return result;
    }

    /**
     * 单链表结构
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
