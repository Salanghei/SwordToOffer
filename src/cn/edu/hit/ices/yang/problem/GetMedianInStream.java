package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数
 */
public class GetMedianInStream {
    public ArrayList<Double> numLst = new ArrayList<>();

    public void insert(Integer num) {
        numLst.add((double)num);
        Collections.sort(numLst);
    }

    public Double getMedian() {
        int len = numLst.size();
        if(len % 2 == 1){
            return numLst.get(len / 2);
        }else{
            return (numLst.get(len / 2 - 1) + numLst.get(len / 2)) / 2;
        }
    }
}
