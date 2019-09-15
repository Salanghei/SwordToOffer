package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述：
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 * 解题思路：
 * 方法一：利用三个指针把链表反转，关键是保存断开的节点
 * 方法二：利用栈来实现
 */
public class PrintListFromTailToHead {
    // 方法一：利用三个指针把链表反转，关键是保存断开的节点
    public ArrayList<Integer> solution1(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<Integer>();
        }

        ListNode head = listNode;
        ListNode next = listNode.next;
        while(next != null){  // 将链表反转
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        // 此时listNode的next还指向第二个节点，将其设为null，防止循环
        listNode.next = null;
        ArrayList<Integer> result = new ArrayList<>();
        while(head != null){
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    // 方法二：利用栈
    public ArrayList<Integer> solution2(ListNode listNode){
        if(listNode == null){
            return new ArrayList<Integer>();
        }

        Stack<Integer> valStack = new Stack<>();
        ListNode head = listNode;
        while(head != null){
            valStack.push(head.val);
            head = head.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!valStack.empty()){
            result.add(valStack.pop());
        }
        return result;
    }
}
