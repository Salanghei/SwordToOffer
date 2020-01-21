package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 解题思路：
 * 注意正数、负数、数值溢出问题
 */
public class StrToInt {
    public int solution(String str){
        if(str == null){
            return 0;
        }
        ArrayList<String> numLst = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        long result = 0;
        int idx = 1;
        for(int i = 0; i < str.length(); i ++){
            if(i == 0 && String.valueOf(str.charAt(i)).equals("-")){
                idx = -1;
                continue;
            }else if(i == 0 && String.valueOf(str.charAt(i)).equals("+")) {
                idx = 1;
                continue;
            }
            if(numLst.contains(String.valueOf(str.charAt(i)))){
                result = result * 10 + idx * numLst.indexOf(String.valueOf(str.charAt(i)));
            }else{
                return 0;
            }
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)result;
        }
    }
}
