package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

/**
 * 题目描述：
 * 输入一个链表，反转链表后，输出新链表的表头
 *
 * 解题思路：
 * 利用三个指针把链表反转，关键是保存断开的节点
 */
public class ReverseList {
    public ListNode Solution(ListNode head){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ListNode next1 = temp.next;
        head.next = null;
        while(next1 != null){
            ListNode next2 = next1.next;
            next1.next = temp;
            temp = next1;
            next1 = next2;
        }
        return temp;
    }
}
