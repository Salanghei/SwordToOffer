package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 解题思路：
 * 直接遍历。
 *
 * 测试用例：
 * 1.输入的字符串中包含空格：
 *     空格位于字符串最前面；空格位于字符串中间；空格位于字符串最后面；字符串中有连续多个空格
 * 2.输入字符串中没有空格
 * 3.特殊输入测试：
 *     字符串是一个null；字符串是一个空字符串；字符串只有一个空格字符；字符串中只有连续多个空格
 *
 */
public class ReplaceBlanks {
    public String replaceBlank(String str){
        if(str == null || str.length() <= 0) {  // 先判断是否为null，在判断是不是空字符串
            return "";
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
