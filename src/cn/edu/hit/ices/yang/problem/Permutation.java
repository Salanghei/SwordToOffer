package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;

/**
 * 题目描述：
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 *
 * 输入描述：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 *
 * 解题思路：
 * 递归：依次抽出每个字符，将剩余字符按要求排列出来并生成列表，
 *       遍历列表，将抽出的字符加到列表中每个字符串的开头
 */
public class Permutation {
    public ArrayList<String> solution(String str){
        ArrayList<String> newList = new ArrayList<>();
        if(str.length() > 0) {
            if (str.length() <= 1) {
                newList.add(str);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    String cAtI = str.substring(i, i + 1);
                    String restStr = str.substring(0, i) + str.substring(i + 1);
                    ArrayList<String> strList = solution(restStr);
                    for (String subStr : strList) {
                        String newStr = cAtI + subStr;
                        if (newList.indexOf(newStr) == -1) {
                            newList.add(newStr);
                        }
                    }
                }
            }
        }
        return newList;
    }
}
