package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.RandomListNode;

import java.util.ArrayList;

/**
 * 题目描述：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 解题思路：
 * 简单复制链表，不处理random指针，并将链表节点保存在list中，用来记录每个节点的索引值
 * 再次遍历链表，处理random指针，在数组中查找random指向的节点的索引k
 * 在新链表中找到第k个索引，并建立指向它的random指针
 */
public class CloneRandomList {
    public RandomListNode solution(RandomListNode pHead){
        ArrayList<RandomListNode> nodeList = new ArrayList<>();
        RandomListNode result = new RandomListNode(0);
        RandomListNode pTemp = pHead, resultTemp = result;
        while (pTemp != null){
            nodeList.add(pTemp);
            resultTemp.next = new RandomListNode(pTemp.label);
            pTemp = pTemp.next;
            resultTemp = resultTemp.next;
        }
        pTemp = pHead;
        resultTemp = result.next;
        while (pTemp != null){
            int index = nodeList.indexOf(pTemp.random);
            if(index >= 0){
                RandomListNode pIndex = result.next;
                for(int i = 0; i < index; i++){
                    pIndex = pIndex.next;
                }
                resultTemp.random = pIndex;
            }
            pTemp = pTemp.next;
            resultTemp = resultTemp.next;
        }
        return result.next;
    }
}
