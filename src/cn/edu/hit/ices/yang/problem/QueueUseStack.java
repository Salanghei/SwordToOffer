package cn.edu.hit.ices.yang.problem;

import java.util.Stack;

/**
 * 题目描述：
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解题思路：
 * 两个栈 stack1 和 stack2:
 * push 动作都在 stack1 中进行，pop 动作在 stack2 中进行
 * 当 stack2 不为空时，直接 pop
 * 当 stack2 为空时，先把 stack1 中的元素 pop 出来，push 到 stack2 中，再从 stack2 中 pop 元素。
 */
public class QueueUseStack {
    Stack<Integer> stack1 = new Stack<Integer>();  // 用来实现push
    Stack<Integer> stack2 = new Stack<Integer>();  // 用来实现pop

    public void push(int node) {
        while(!stack2.empty()){
            int tempNode = stack2.pop();
            stack1.push(tempNode);
        }
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()) {
            while (!stack1.empty()) {
                int tempNode = stack1.pop();
                stack2.push(tempNode);
            }
        }
        return stack2.pop();
    }
}
