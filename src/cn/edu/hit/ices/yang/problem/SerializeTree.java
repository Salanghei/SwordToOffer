package cn.edu.hit.ices.yang.problem;

import cn.edu.hit.ices.yang.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 解题思路：
 * 使用层序遍历
 */
public class SerializeTree {
    public String serialize(TreeNode root){
        if(root == null) return "!";
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            if(tempNode == null){
                result.append("#!");
                continue;
            }else{
                result.append(tempNode.val);
                result.append("!");
            }
            queue.add(tempNode.left);
            queue.add(tempNode.right);
        }
        return result.toString();
    }

    public TreeNode deserialize(String str){
        if(str.equals("!")) return null;
        String[] strings = str.split("!");
        int level = 1, start = 1, levelNum = 1;    // level表示层数，start表示每层的起始索引，levelNum表示每层最多节点数
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(start < strings.length){
            levelNum = levelNum * 2;
            for(int i = start; i < start + levelNum && i < strings.length; i = i + 2){
                TreeNode tempNode1 = null;
                if(!strings[i].equals("#")){
                    tempNode1 = new TreeNode(Integer.valueOf(strings[i].trim()));
                    queue.add(tempNode1);
                }
                TreeNode tempNode2 = null;
                if(!strings[i + 1].equals("#")){
                    tempNode2 = new TreeNode(Integer.valueOf(strings[i + 1].trim()));
                    queue.add(tempNode2);
                }
                TreeNode parent = queue.poll();
                parent.left = tempNode1;
                parent.right = tempNode2;
            }
            start = start + levelNum;
            level ++;
        }
        return root;
    }
}
