package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 *
 * 解题思路：
 * 遍历字符串，将每个字符映射到字符数组中，字符数组保存：
 *       -1：字符未出现
 *       -2：字符串限次数超过1次
 *       index：仅出现一次的字符在str中的索引
 *       字符数组的索引：字符的ascii码相对于'A'的大小
 */
public class FirstNotRepeatingChar {
    public int Solution(String str){
        int[] chars = new int['z' - 'A' + 1];
        for(int i = 0; i < 'z' - 'A' + 1; i ++){
            chars[i] = -1;
        }
        for(int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            if(chars[c - 'A'] == -1){  // -1表示未出现
                chars[c - 'A'] = i;    // 记录字符在str中的位置
            }else{
                chars[c - 'A'] = -2;   // 表示出现了不止1次
            }
        }
        int index = str.length();
        for(int i = 0; i < 'z' - 'A' + 1; i ++){
            if(chars[i] != -1 && chars[i] != -2){  // 未出现且出现超过1次的
                if(index > chars[i]){
                    index = chars[i];
                }
            }
        }
        if(index == str.length()){
            index = -1;
        }
        return index;
    }
}
