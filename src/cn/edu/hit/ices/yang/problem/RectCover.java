package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 *
 * 解题思路：
 * 同JumpFloor
 */
public class RectCover {
    public int solution(int target){
        if(target <= 2){
            return target;
        }
        int pre1 = solution(target - 1);
        int pre2 = solution(target - 2);
        return pre1 + pre2;
    }
}
