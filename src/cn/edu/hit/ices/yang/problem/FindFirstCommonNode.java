package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

/**
 * 题目描述：
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 解题思路：
 * 公共节点：两个链表从某一节点开始，他们的next都指向同一个节点
 */
public class FindFirstCommonNode {
    public ListNode solution(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null) p1 = pHead2;
                if(p2 == null) p2 = pHead1;
            }
        }
        return p1;
    }
}
