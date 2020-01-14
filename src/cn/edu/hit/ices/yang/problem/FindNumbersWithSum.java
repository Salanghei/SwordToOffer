package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;

/**
 * 题目描述：
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的
 *
 * 输出描述：
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 解题思路：
 * 从中间开始向两侧遍历数组，寻找两个数的同时比较乘积的大小
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> solution(int[] array, int sum){
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0){
            return result;
        }
        int mul = array[array.length - 1] * array[array.length - 1];
        int mid = array.length / 2;
        int low = mid, high = mid + 1;
        while(low >= 0 && high <= array.length - 1){
            System.out.println(array[low] + "," + array[high]);
            if (array[low] + array[high] == sum) {
                if(array[low] * array[high] < mul) {
                    result = new ArrayList<>();
                    result.add(array[low]);
                    result.add(array[high]);
                }
                low--;
                high++;
            }else if(array[low] + array[high] < sum){
                high ++;
            }else{
                low --;
            }
        }
        return result;
    }
}
