package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 给定一个double类型的浮点数base和int类型的整数exponent，求base的exponent次方
 *
 * 解题思路：
 *     1.指数为负时，可以先对指数求绝对值，算出次方的结果后再取倒数
 *     2.当底数为0，指数为负时，会出现对0求倒数情况，要特殊处理
 *     3.0的0次方在数学上没有意义，因此无论输出0还是1都是可以接受的
 *     4.在计算次方的时候，除了简单的遍历，我们可以使用递归的思想，来减少计算量：
 */
public class Power {
    public double solution(double base, int exponent){
        int temp = exponent;
        if(exponent == 0){
            return 1;
        }else if(exponent < 0){
            if(base == 0){
                throw new RuntimeException("分母不能为0");
            }
            temp = - exponent;
        }
        if(exponent > 0){
            return PowerUnsignedExponent(base, temp);
        }else{
            return 1 / PowerUnsignedExponent(base, temp);
        }
    }

    public double PowerUnsignedExponent(double base, int exponent){
        if(exponent == 1){
            return base;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent % 2 == 0){
            return PowerUnsignedExponent(base, exponent / 2)
                    * PowerUnsignedExponent(base, exponent / 2);
        }else{
            return PowerUnsignedExponent(base, exponent / 2)
                    * PowerUnsignedExponent(base, exponent / 2) * base;
        }
    }
}
