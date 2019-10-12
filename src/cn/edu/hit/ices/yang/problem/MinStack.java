package cn.edu.hit.ices.yang.problem;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * 解题思路：
 * 采用两个栈实现：
 *     1. 正常存储数据的栈，正常向其中压入数据即可
 *     2. 存储最小数据的栈：压入的第n个数据为前n个数据中的最小值
 */
public class MinStack {
    Stack<Integer> stackMin = new Stack<>();  // 有顶到底是按从小到大的顺序排列
    Stack<Integer> stack = new Stack<>();

    public void push(int node){
        stack.push(node);
        if(stackMin.empty()){
            stackMin.push(node);
        }else{
            if(stackMin.peek() >= node){
                stackMin.push(node);
            }else{
                stackMin.push(stackMin.peek());
            }
        }
    }

    public void pop(){
        stackMin.pop();
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int min(){
        return stackMin.peek();
    }
}
