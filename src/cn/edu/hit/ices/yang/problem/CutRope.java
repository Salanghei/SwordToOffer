package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 大佬解题思路：
 * 贪婪算法：
 *     尽量把大于5的数分解成3的乘积，如果剩下的长度为4，则把4分解成2和2，因为3\times× 1 < 2 \times× 2。
 */
public class CutRope {
    public int solution(int target){
        int result = 0;
        for(int m = 2; m < target; m ++){
            int part = target / m;
            if(target % m != 0){
                part = part + 1;
            }
            int mul = (int)Math.pow(part, m - 1) * (target - part * (m - 1));
            if(mul > result){
                result = mul;
            }
        }
        return result;
    }
}
