package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 解题思路：
 * 如果当前字符串和模式串均为""，则返回true；如果仅模式串为""，则返回true；否则考虑两种情况：
 * 1. 模式串的当前字符的下一个字符为'*'时，考虑字符串中匹配了0个或多个模式串的当前字符：
 *     如果匹配了0个当前字符，则模式串中索引向后移2位，继续匹配；如果匹配了1个或多个，则字符串索引向后移1位，
 *     当匹配到当前能匹配的最后一个字符时，将模式串的索引向后移2位；
 * 2. 模式串的当前字符的下一个字符不是'*'时，直接匹配，无法匹配则返回false
 */
public class Match {
    public boolean solution(char[] str, char[] pattern){
        return matchStr(str, 0, pattern, 0);
    }

    private boolean matchStr(char[] str, int strIndex, char[] pattern, int patternIndex){
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }else if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }

        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if(strIndex < str.length && (pattern[patternIndex] == '.' || pattern[patternIndex] == str[strIndex])){
                return matchStr(str, strIndex + 1, pattern, patternIndex) || matchStr(str, strIndex, pattern, patternIndex + 2);
            }else{    // *匹配0个字符时
                return matchStr(str, strIndex, pattern, patternIndex + 2);
            }
        }else{
            if(strIndex < str.length && (pattern[patternIndex] == '.' || pattern[patternIndex] == str[strIndex])){
                return matchStr(str, strIndex + 1, pattern, patternIndex + 1);
            }else{
                return false;
            }
        }
    }
}
