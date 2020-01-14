package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;

/**
 * 题目描述：
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述：
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 解题思路：
 * 假设连续k个整数的和为sum，可求出这些整数的平均值是sum/k
 * 如果k是奇数，sum/k就是这k个数的中间数，sum/k必为整数，即可得到一个序列；
 * 如果k是偶数，sum/k就是这k个数中间两个数的平均数，sum/k必为小数位为0.5的数，即可得到一个序列；
 * 最后检测得到的序列相加是否为sum
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> solution(int sum){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum <= 0){
            return result;
        }
        for(int i = sum; i >= (sum % 2 == 1 ? 2 : 3); i --){
            float avgDouble = sum / i;
            int avgInt = sum / i;
            int start = 0;
            if(i % 2 == 1){
                if(avgInt * i == sum){
                    start = avgInt - i / 2;
                }
            }else{
                if(avgInt * i + i / 2 == sum){
                    start = avgInt - i / 2 + 1;
                }
            }
            if(start > 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = start; j < start + i; j++) {
                    temp.add(j);
                }
                result.add(temp);
            }
        }
        return result;
    }
}
