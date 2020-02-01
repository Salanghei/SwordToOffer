package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeLinkNode;

import java.util.ArrayList;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    ArrayList<TreeLinkNode> nodeLst = new ArrayList<>();
    public TreeLinkNode solution(TreeLinkNode pNode){
        TreeLinkNode root = pNode;
        while(root.next != null){
            root = root.next;
        }
        inOrder(root);
        for(int i = 0; i < nodeLst.size(); i ++){
            if(pNode == nodeLst.get(i)){
                if(i == nodeLst.size() - 1){
                    return null;
                }else{
                    return nodeLst.get(i + 1);
                }
            }
        }
        return null;
    }

    private void inOrder(TreeLinkNode root){
        if(root != null){
            inOrder(root.left);
            nodeLst.add(root);
            inOrder(root.right);
        }
    }
}
