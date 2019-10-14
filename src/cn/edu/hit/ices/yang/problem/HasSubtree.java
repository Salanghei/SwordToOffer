package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述：
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 解题思路：
 * 先比较两棵树的根节点，如果相等，则再比较两棵树的左右子节点
 * 如果根节点不相等，则比较A树左节点和B树根节点，或者A树右节点和B树根节点
 * 以此类推
 * 当B树遍历完成时，说明B树为A树的子结构，返回true
 * 当A树遍历完成，B树未遍历完成时，说明B树不是A树的子结构，返回false
 *
 * 注：如果是判断是否是子树，只需将最终条件调整一下即可
 */
public class HasSubtree {
    public boolean solution(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return false;
        }
        return compareTree(root1, root2) || solution(root1.left, root2) || solution(root1.right, root2);
    }

    // 判断root2是否是root1的子结构
    private boolean compareTree(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return compareTree(root1.left, root2.left) && compareTree(root1.right, root2.right);
    }
}
