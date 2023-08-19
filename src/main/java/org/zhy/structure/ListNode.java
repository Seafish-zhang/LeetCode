package org.zhy.structure;

/**
 * 链表
 * 为了LeetCode题目，将属性全部设置位public，正常开发不建议这样做
 */
public class ListNode {
    public int val;
    public ListNode next;

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
