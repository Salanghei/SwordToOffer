package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

import java.util.ArrayList;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 解题思路：
 * 二叉搜索树中序遍历的结果是排好序的
 */
public class KthNode {
    private ArrayList<TreeNode> nodeLst = new ArrayList<>();
    public TreeNode solution(TreeNode pRoot, int k){
        InOrderFind(pRoot);
        if(nodeLst.size() < k || k <= 0) return null;
        return nodeLst.get(k - 1);
    }

    private void InOrderFind(TreeNode pRoot){
        if(pRoot != null){
            InOrderFind(pRoot.left);
            nodeLst.add(pRoot);
            InOrderFind(pRoot.right);
        }
    }
}

// 大佬版本，不需要全部遍历，找到第k个节点即停止
// 注意当搜到第k个节点时，如何终止继续向下的无用搜索？
/*public class Solution {

    TreeNode treeNode = null;
    int count = 0;

    void dfs(TreeNode pRoot, int k) {

        if (count < k && pRoot.left != null) {
            dfs(pRoot.left, k);
        }

        if (++count == k) {
            treeNode = pRoot;
        }

        if (count < k && pRoot.right != null) {
            dfs(pRoot.right, k);
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        dfs(pRoot, k);
        return treeNode;
    }
}*/
