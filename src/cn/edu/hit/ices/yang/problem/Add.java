package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 解题思路：
 * 1. 两个数二进制异或得到各个位相加的结果sum
 * 2. 两个数二进制与，再左移一位得到进位ans
 * 3. 如果ans未0，那么sum为结果，否则将sum与ans进行异或得到结果
 */
public class Add {
    public int solution(int num1, int num2){
        int sum = num1 ^ num2;
        int ans = (num1 & num2) << 1;
        while(ans != 0){
            num1 = sum;
            num2 = ans;
            sum = num1 ^ num2;
            ans = (num1 & num2) << 1;
        }
        return sum;
    }
}
