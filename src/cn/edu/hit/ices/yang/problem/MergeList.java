package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.ListNode;

import java.util.List;
import java.util.ListIterator;

/**
 * 题目描述：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 *
 * 解题思路：
 * 方法一：将两个链表结点挨个进行比较，插入到一个新表中
 * 方法二：递归
 *     递归出口：假设链表1遍历完成，链表2未遍历完成，那么直接将链表2接到合并后的链表末尾即可；
 *     其他情况：假设链表1当前val小于链表2当前val，那么此处一定选取链表1的当前节点，
 *              后续链表一定连接在链表1当前节点之后
 */
public class MergeList {
    public ListNode Solution1(ListNode list1, ListNode list2){
        ListNode resultTemp = new ListNode(0);
        ListNode result = resultTemp;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                resultTemp.next = list1;
                list1 = list1.next;
            }else{
                resultTemp.next = list2;
                list2 = list2.next;
            }
            resultTemp = resultTemp.next;
        }
        resultTemp.next = list1 == null ? list2 : list1;
        return result.next;
    }

    public ListNode Solution2(ListNode list1, ListNode list2){
        if(list1 == null){  // 递归出口
            return list2;
        }
        if(list2 == null){  // 递归出口
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = Solution2(list1.next, list2);
            return list1;
        }else{
            list2.next = Solution2(list1, list2.next);
            return list2;
        }
    }
}
