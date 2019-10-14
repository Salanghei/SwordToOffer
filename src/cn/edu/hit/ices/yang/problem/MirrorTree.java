package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述：
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 *
 * 输入描述：
 * 二叉树的镜像定义：
 * 源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 * 镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *  解题思路：
 *      递归：递归出口为，当root为null时返回null
 *            其他情况下，将root的左右子节点调换位置
 */
public class MirrorTree {
    public void solution(TreeNode root){
        if(root == null){
            return;
        }
        solution(root.left);
        TreeNode temp =root.left;
        solution(root.right);
        root.left = root.right;
        root.right = temp;
    }
}
