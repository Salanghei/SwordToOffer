package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

/**
 * 题目描述：
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * 解题思路：
 * 快慢指针：
 * 快指针先往前走k步，注意判断边界，然后快慢一起走
 * 当快指针为null的时候，慢指针走到了倒数第k个节点
 */
public class FindKthToTail {
    // 暴力解法
    public ListNode solution1(ListNode head, int k){
        ListNode root = head;
        int count = 0;
        while(root != null){
            count ++;
            root = root.next;
        }
        if(count < k){  // 输入k的位置大于链表节点数量
            return null;
        }
        ListNode result = head;
        for(int i = 0; i < count - k; i ++){
            result = result.next;
        }
        return result;
    }

    // 大佬解法
    public ListNode solution2(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k; i++){
            if(fast == null){  // 输入head为null时；或输入k大于链表节点个数时
                return null;
            }
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
