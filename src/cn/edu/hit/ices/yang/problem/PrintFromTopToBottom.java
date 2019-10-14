package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 *
 * 解题思路：
 * 二叉树的层序遍历
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> solution(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                root = queue.poll();
                result.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
        }
        return result;
    }
}
