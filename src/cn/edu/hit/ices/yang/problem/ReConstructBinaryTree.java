package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

/**
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 *
 * 解题思路：
 * 我们知道，前序遍历的第一个节点就是树的根节点，所以我们先根据前序遍历序列的第一个数字创建根结点
 * 接下来在中序遍历序列中找到根结点的位置，根节点的左边就是左子树，右边就是右子树，这样就能确定左、右子树结点的数量
 * 在前序遍历和中序遍历的序列中划分了左、右子树结点的值之后，就可以递归地去分别构建它的左右子树
 */
public class ReConstructBinaryTree {
    public TreeNode solution(int[] pre, int[] in){
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        return constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    // 递归构建树
    public TreeNode constructBinaryTree(int[] pre, int pIndexLeft, int pIndexRight,
                                        int[] in, int iIndexLeft, int iIndexRight){
        if(pIndexLeft > pIndexRight || iIndexLeft > iIndexRight){
            return null;
        }
        TreeNode head = new TreeNode(pre[pIndexLeft]);
        for(int i = iIndexLeft; i <= iIndexRight; i++){
            if(in[i] == pre[pIndexLeft]){
                head.left = constructBinaryTree(pre, pIndexLeft + 1, pIndexLeft + i - iIndexLeft, in, iIndexLeft, i - 1);
                head.right = constructBinaryTree(pre, pIndexLeft + i - iIndexLeft + 1 , pIndexRight, in, i + 1, iIndexRight);
                break;
            }
        }
        return head;
    }
}
