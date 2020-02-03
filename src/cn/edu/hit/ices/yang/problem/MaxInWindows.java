package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public ArrayList<Integer> solution(int[] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(size <= 0 || size > num.length) return result;
        for(int i = 0; i <= num.length - size; i ++){
            int max = 0;
            for(int j = i; j < i + size; j ++){
                if(num[j] > max){
                    max = num[j];
                }
            }
            result.add(max);
        }
        return result;
    }
}

/**
 * 大佬解法：
 * 链接：https://www.nowcoder.com/questionTerminal/1624bc35a45c42c0bc17d17fa0cba788?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 单调队列
 * 利用这条性质：当A < B且num[A] < num[B]时，num[A]对右端点在B或之后的区间来说可以忽略，因为num[B]是个更优解且num[A]先过期。
 * 于是维护一个单调队列，队列中的元素由高到低排列（队列中存下标，方便判断过期）。
 * 从小到大扫描num数组，当考虑到下标B时，根据上面的性质，可以安全地从队尾删除所有比num[B]小的值。
 * 然后将B加入队尾。
 * 然后从队首删除所有过期的值。
 * 做完以上3点之后，队首的值即为以B为右端点的区间的最大值。
 * 时间和空间复杂度都是O(N)，因为每个元素只进出一次队列。
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 */
