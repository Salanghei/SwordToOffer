package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * 不能使用除法
 *
 * 解题思路：
 * 制造两个中间数组，mulPre,mulLast，
 * 其中，mulPre的索引i中的数为数组A中的索引i前所有数的乘积，
 * mulLast的索引i中的为数组A中索引i后的所有数的乘积
 * 最终结果result中的索引i中的数为mulPre和mulLast的索引i中的数的乘积
 */
public class Multiply {
    public int[] solution(int[] A){
        int[] mulPre = new int[A.length];
        int[] mulLast = new int[A.length];
        int[] result = new int[A.length];
        int mul = 1;
        for(int i = 0; i < A.length; i ++){
            mulPre[i] = mul;
            mul = mul * A[i];
        }
        mul = 1;
        for(int i = A.length - 1; i >= 0; i --){
            mulLast[i] = mul;
            mul = mul * A[i];
        }
        for(int i = 0; i < A.length; i ++){
            result[i] = mulPre[i] * mulLast[i];
        }
        return result;
    }
}
