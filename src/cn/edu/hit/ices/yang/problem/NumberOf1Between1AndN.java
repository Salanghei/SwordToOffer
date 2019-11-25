package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1到n中1出现的次数）
 *
 * 解题思路：
 * 遍历1到n，对于其中的每个数字num，如果num%10==1，则这个num的个位是1，
 * 令num=num/10，也就是再取这个num去掉个位的前几位，再作上述判断，直到num为0为止，
 * 这就得到了一个num中包含了几个1
 */
public class NumberOf1Between1AndN {
    public int Solution(int n){
        int count = 0;
        for(int i = 1; i <= n; i ++){
            int num = i;
            while(num != 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }
}
