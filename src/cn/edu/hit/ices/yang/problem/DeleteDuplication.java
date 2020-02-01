package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode solution(ListNode pHead){
        if(pHead == null || pHead.next == null) return pHead;

        ListNode head = new ListNode(-1);    // 新建一个节点头
        ListNode pLast = head;

        while(pHead != null){
            ListNode pNext = pHead.next;
            boolean flag = false;
            while(pNext != null && pHead.val == pNext.val){
                flag = true;
                pNext = pNext.next;
            }
            if(!flag){
                pLast.next = pHead;
                pLast = pLast.next;
            }
            pHead = pNext;
        }
        pLast.next = null;
        return head.next;
    }
}
