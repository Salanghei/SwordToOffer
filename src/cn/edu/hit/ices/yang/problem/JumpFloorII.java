package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * 解题思路：
 * 方法一：同JumpFloor
 * 方法二：f(n)=f(n-1)+f(n-2)+……f(1)
 *        f(n-1)=f(n-2)+……f(1)
 *        两式相减得f(n)=2f(n-1)
 */
public class JumpFloorII {
    // 同JumpFloor
    public int solution1(int target){
        if(target == 1){
            return target;
        }
        int count = 1, n = 1;
        while(n < target){
            count += solution1(target - n);
            n ++;
        }
        return count;
    }

    // f(n)=f(n-1)+f(n-2)+……f(1)
    // f(n-1)=f(n-2)+……f(1)
    // 两式相减得f(n)=2f(n-1)
    public int solution2(int target){
        int count = 1;
        for(int i = 2; i <= target; i ++){
            count *= 2;
        }
        return count;
    }
}
