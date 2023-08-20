package org.zhy.thousand.hundred;

import org.zhy.structure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode tmp = new ListNode();
        tmp.next = head;
        ListNode tail = tmp;
        if (tmp.next == null || tmp.next.next == null) {
            return head;
        }

        while (tail.next != null && tail.next.next != null) {
            ListNode next = tail.next;
            ListNode nextNext = tail.next.next;
            next.next = nextNext.next;
            nextNext.next = next;
            tail.next = nextNext;
            tail = tail.next.next;
        }
        return tmp.next;
    }
}
