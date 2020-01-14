package cn.edu.hit.ices.yang.problem;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目描述：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写程序找出这两个只出现一次的数字
 *
 * 解题思路：
 * 先将数组排序，则相同大小的数会排在一起
 * 按顺序将数组中的数入栈，遇到相同的数则弹出
 * 最终留在栈中的两个数即是只出现了一次的数
 */
public class FindNumsAppearOnce {
    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    public void solution(int[] array, int[] num1, int[] num2){
        Arrays.sort(array);
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i < array.length; i ++){
            if(stack.empty()){
                stack.push(array[i]);
            }else {
                if (stack.peek() == array[i]) {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            }
        }
        num1[0] = stack.pop();
        num2[0] = stack.pop();
    }
}
