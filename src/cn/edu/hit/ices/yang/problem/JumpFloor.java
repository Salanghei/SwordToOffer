package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 *
 * 解题思路：递归
 * 当台阶数为1时，只有1种方法，即跳1级台阶，1步跳完
 * 当台阶数为2时，有2种方法：每次跳1级台阶，跳2步；每次跳2级台阶，跳1步
 * 当台阶数为3时，考虑两种情况：
 *     1.最后一步跳1级台阶，则之前需要跳2级台阶，有2种跳法
 *     2.最后一步跳2级台阶，则之前需要跳1级台阶，有1种跳法
 *     综上，跳3级台阶有2+1种跳法
 * 当台阶数为n时，考虑两种情况：
 *     1.最后一步跳1级台阶，则之前需要跳n-1级台阶，有pre1种跳法
 *     2.最后一步跳2级台阶，则之前需要跳n-2级台阶，有pre2种跳法
 *     综上，跳3级台阶有pre1+pre2种跳法
 */
public class JumpFloor {
    public int solution(int target){
        if(target == 1 || target == 2){
            return target;
        }
        int pre1 = solution(target - 1);
        int pre2 = solution(target - 2);
        return pre1 + pre2;
    }
}
