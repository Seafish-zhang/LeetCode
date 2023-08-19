package org.zhy;

import org.zhy.structure.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 先然快指针走n步
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // 删除的下标位第一位
                return head.next;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            return null;
        }
        return head;
    }
}
