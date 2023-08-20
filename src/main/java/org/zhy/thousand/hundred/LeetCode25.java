package org.zhy.thousand.hundred;

import org.zhy.structure.ListNode;

/**
 * 25 K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class LeetCode25 {

    public static void main(String[] args) {
        int length = 6;
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 1; i < length; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        new LeetCode25().reverseKGroup(head, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        // 每组翻转结尾标准
        ListNode tail;
        // 每组翻转前头标准
        ListNode pre;
        ListNode current = root;
        while (current.next != null) {
            pre = current;
            current = current.next;
            tail = pre;
            // 判断是否满足一组
            for (int i = 0; i < k; i++) {
                if (tail.next == null) {
                    return root.next;
                }
                tail = tail.next;
            }
            ListNode tn = tail.next;
            while (current.next != tn) {
                ListNode next = current.next;
                current.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
        }
        return root.next;
    }
}
