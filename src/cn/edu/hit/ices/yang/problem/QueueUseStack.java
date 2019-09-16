package cn.edu.hit.ices.yang.problem;

import java.util.Stack;

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
