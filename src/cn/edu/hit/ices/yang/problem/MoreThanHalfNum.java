package cn.edu.hit.ices.yang.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2，如果不存在则输出0
 *
 * 解题思路：
 * 遍历数组
 */
public class MoreThanHalfNum {
    public int solution(int[] array){
        int result = 0;
        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i ++){
            int count = 1;
            if(map.containsKey(array[i])){
                count = map.get(array[i]) + 1;
            }
            map.put(array[i], count);
            if(count > len/2){
                result = array[i];
            }
        }
        return result;
    }
}
