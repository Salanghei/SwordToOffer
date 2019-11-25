package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数
 * 求按从小到大的顺序的第N个丑数
 *
 * 解题思路：
 * 可以将丑数看成2^a*3^b*5^c，a,b,c都是非负整数，将这些书由小到大排序，找到第index个
 * 排序思路：新的丑数一定是由已有的丑数通过*2或*3或*5得到的
 */
public class GetUglyNumber {
    public int Solution(int index){
        if(index <= 0){
            return 0;
        }
        int a = 0, b = 0, c = 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        for(int i = 1; i < index; i ++){
            int newUglyNumber = Math.min(uglyNumbers[a] * 2,
                    Math.min(uglyNumbers[b] * 3, uglyNumbers[c] * 5));
            if(newUglyNumber == uglyNumbers[a] * 2){
                a ++;
            }
            if(newUglyNumber == uglyNumbers[b] * 3){
                b ++;
            }
            if(newUglyNumber == uglyNumbers[c] * 5){
                c ++;
            }
            uglyNumbers[i] = newUglyNumber;
        }
        return uglyNumbers[index - 1];
    }
}
