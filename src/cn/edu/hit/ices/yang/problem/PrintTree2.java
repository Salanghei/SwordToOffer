package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 解题思路：
 * 层序遍历
 */
public class PrintTree2 {
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
        return result;
    }
}
