package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

import java.util.ArrayList;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 解题思路：
 * 遍历链表，遇到的第一个重复的节点即为环的入口
 */
public class EntryNodeOfLoop {
    public ListNode solution(ListNode pHead){
        ArrayList<ListNode> nodeLst = new ArrayList<>();
        ListNode node = pHead;
        while(node != null){
            if(nodeLst.contains(node)){
                break;
            }else{
                nodeLst.add(node);
                node = node.next;
            }
        }
        return node;
    }
}
