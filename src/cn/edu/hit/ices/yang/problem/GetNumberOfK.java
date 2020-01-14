package cn.edu.hit.ices.yang.problem;

import java.util.Arrays;

/**
 * 题目描述：
 * 统计一个数字在排序数组中出现的次数。
 *
 * 解题思路：
 * 使用二分法找到k在数组中的位置，统计k出现的次数
 */
public class GetNumberOfK {
    public int solution(int[] array, int k){
        int index = Arrays.binarySearch(array, k);
        if(index < 0) return 0;
        int count = 1;
        for(int i = index + 1; i < array.length && array[i] == k; i ++){
            count ++;
        }
        for(int i = index - 1; i >= 0 && array[i] == k; i --){
            count ++;
        }
        return count;
    }
}
