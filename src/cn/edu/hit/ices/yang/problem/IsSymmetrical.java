package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 解题思路：
 * 中序遍历，左子树左中右，右子树右中左
 */
public class IsSymmetrical {
    public boolean solution(TreeNode pRoot){
        if(pRoot == null) return true;
        return isSimilar(pRoot.left, pRoot.right);
    }

    private boolean isSimilar(TreeNode pLeft, TreeNode pRight){
        if(pLeft != null && pRight != null) {
            boolean left = isSimilar(pLeft.left, pRight.right);
            boolean middle = pLeft.val == pRight.val;
            boolean right = isSimilar(pLeft.right, pRight.left);
            return left && middle && right;
        }
        return pLeft == null && pRight == null;
    }
}
