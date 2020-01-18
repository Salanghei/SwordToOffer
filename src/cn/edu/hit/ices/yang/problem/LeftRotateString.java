package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 解题思路：
 * 字符串截取
 */
public class LeftRotateString {
    public String solution(String str, int n){
        if(str == null || str.length() < n){
            return "";
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n);
        return str2 + str1;
    }
}
