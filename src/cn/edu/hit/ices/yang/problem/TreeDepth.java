package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述：
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 *
 * 解题思路：
 * 后序遍历二叉树，记录每个结点上的树的深度，该深度其左右子树的最大深度+1
 */
public class TreeDepth {
    public int solution(TreeNode root){
        int depth = lastOrderTree(root);
        return depth;
    }

    private int lastOrderTree(TreeNode root){
        if(root != null){
            int depthLeft = lastOrderTree(root.left);
            int depthRight = lastOrderTree(root.right);
            return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
        }else{
            return 0;
        }
    }
}
