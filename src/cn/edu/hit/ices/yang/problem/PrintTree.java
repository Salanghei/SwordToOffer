package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

import java.util.*;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解题思路：
 * 层序遍历，在偶数行将节点倒序
 */
public class PrintTree {
    private static class Element{
        int level;
        TreeNode node;
    }

    public ArrayList<ArrayList<Integer>> solution(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;

        Queue<Element> queue = new LinkedList<>();
        Element element = new Element();
        element.level = 0;
        element.node = pRoot;
        queue.add(element);
        while(!queue.isEmpty()){
            Element tempNode = queue.poll();
            if(tempNode.node == null) continue;

            if(tempNode.level == result.size()){
                if(tempNode.level > 0 && (tempNode.level - 1) % 2 == 1){
                    Collections.reverse(result.get(tempNode.level - 1));
                }
                result.add(new ArrayList<>());
            }
            result.get(tempNode.level).add(tempNode.node.val);

            Element left = new Element();
            left.node = tempNode.node.left;
            left.level = tempNode.level + 1;
            Element right = new Element();
            right.node = tempNode.node.right;
            right.level = tempNode.level + 1;
            queue.add(left);
            queue.add(right);
        }
        if(result.size() % 2 == 0){
            Collections.reverse(result.get(result.size() - 1));
        }
        return result;
    }
}
