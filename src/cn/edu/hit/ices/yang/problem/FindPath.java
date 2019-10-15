package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述：
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * 注意: 在返回值的list中，数组长度大的数组靠前
 *
 * 解题思路：
 * 要解决这个问题，需要以下步骤：
 *     1.以左孩子为根的树，和为target-root.val的路径（子问题）
 *     2.以右孩子为根的树，和为target-root.val的路径（子问题）
 *     3.遍历1、2两步得到的路径结果，然后将root.val插到路径结果最前面
 * 可以看出这个问题的结果可以由其子问题的结果合并得到，所以可以使用递归来解决
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> solution(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root != null && target != 0){
            Stack<Integer> nodeVal = new Stack<>();
            findPathInTree(root, target, result, nodeVal);
        }
        return result;
    }

    private TreeNode findPathInTree(TreeNode root, int target,
                                    ArrayList<ArrayList<Integer>> result,
                                    Stack<Integer> nodeVal){
        if(target - root.val >= 0){
            nodeVal.push(root.val);
            target = target - root.val;
            if(root.left != null) {
                root.left = findPathInTree(root.left, target, result, nodeVal);
            }
            if(root.right != null) {
                root.right = findPathInTree(root.right, target, result, nodeVal);
            }
            if(root.left == null && root.right == null){
                if(target == 0) {
                    result.add(new ArrayList<>(nodeVal));
                }
                nodeVal.pop();
                return null;
            }
        }
        return root;
    }
}
