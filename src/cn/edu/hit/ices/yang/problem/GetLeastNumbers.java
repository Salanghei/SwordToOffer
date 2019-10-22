package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;

/**
 * 题目描述：
 * 输入n个整数，找出其中最小的K个数
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 *
 * 解题思路：
 * 将整数排序，使用冒泡排序，只将前k小的数排出来
 */
public class GetLeastNumbers {
    public ArrayList<Integer> solution(int[] input, int k){
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length >= k) {
            for(int i = 0; i < k; i ++){
                for(int j = input.length - 1; j > i; j --){
                    if(input[j] < input[j - 1]){
                        int temp = input[j];
                        input[j] = input[j - 1];
                        input[j - 1] = temp;
                    }
                }
                result.add(input[i]);
            }
        }
        return result;
    }
}
