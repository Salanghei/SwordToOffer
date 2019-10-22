package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 *   在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决
 *   但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *   例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 解题思路：
 * 1、暴力解法：遍历
 * 2、从前往后遍历，最大的连续子序列的和是由当前元素和之前的最大连续子序列的和叠加在一起形成的
 *    如果之前的最大连续子序列的和大于零，我们可以继续累加，
 *    如果小于零，则需要舍去之前的子序列，重新从当前的数字开始累加。时间复杂度为O(n)
 */
public class FindGreatestSumOfSubArray {
    public int solution1(int[] array){
        int maxSum = 0;
        if(array.length > 0) {
            maxSum = array[0];
            for (int i = 0; i < array.length; i++) {
                int result = 0;
                for (int j = i; j < array.length; j++) {
                    result = result + array[j];
                    if (result > maxSum) {
                        maxSum = result;
                    }
                }
            }
        }
        return maxSum;
    }

    public int solution2(int[] array){
        int maxSum = 0;
        if(array.length > 0){
            maxSum = array[0];
            int sum = 0;
            for(int i = 0; i < array.length; i++){
                if(sum < 0){
                    sum = array[i];
                }else{
                    sum += array[i];
                }
                maxSum = (sum > maxSum) ? sum : maxSum;
            }
        }
        return maxSum;
    }
}
