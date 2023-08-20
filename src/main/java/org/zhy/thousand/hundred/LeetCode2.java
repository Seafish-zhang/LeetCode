package org.zhy.thousand.hundred;

import org.zhy.structure.ListNode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
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

}
