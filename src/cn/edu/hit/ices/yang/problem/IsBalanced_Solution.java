package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述：
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 *
 * 解题思路：
 * 平衡二叉树：左右子树的深度差不超过1，且左右子树都是平衡二叉树
 * 后序遍历，同时计算深度
 */
public class IsBalanced_Solution {
    public boolean solution(TreeNode root){
        int depth = lastOrderTree(root);
        return depth >= 0;
    }

    private int lastOrderTree(TreeNode root){
        if(root != null){
            int depthLeft = lastOrderTree(root.left);
            int depthRight = lastOrderTree(root.right);
            if(depthLeft < 0 || depthRight < 0 || depthLeft - depthRight > 1 || depthRight - depthLeft > 1){
                return -1;
            }
            return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
        }
        return 0;
    }
}
