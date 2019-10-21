package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 * 解题思路：
 *     中序遍历二叉树，在原打印语句的位置重设左右指针
 */
public class Convert {
    private TreeNode preNode = null;

    public TreeNode solution(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        solution(pRootOfTree.right);
        if(preNode != null){
            preNode.left = pRootOfTree;
            pRootOfTree.right = preNode;
        }
        preNode = pRootOfTree;
        solution(pRootOfTree.left);
        return preNode;
    }
}
