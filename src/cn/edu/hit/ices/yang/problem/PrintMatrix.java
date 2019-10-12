package cn.edu.hit.ices.yang.problem;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4X4矩阵：
 *     1    2   3   4
 *     5    6   7   8
 *     9    10  11  12
 *     13   14  15  16
 *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *  解题思路：
 *  记录矩阵每行每列组要遍历的部分的最低索引和最高索引
 *  依次遍历最上面一行、最右边一列、最下面一行、最左边一列
 */
public class PrintMatrix {
    public ArrayList<Integer> solution(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        int up = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while(true){
            for(int column = left; column <= right; column ++){  // 最上面一行
                result.add(matrix[up][column]);
            }
            up ++;
            if(up > down){
                break;
            }
            for(int row = up; row <= down; row ++){  // 最右边一列
                result.add(matrix[row][right]);
            }
            right --;
            if(left > right){
                break;
            }
            for(int column = right; column >= left; column --){  // 最下面一行
                result.add(matrix[down][column]);
            }
            down --;
            if(up > down){
                break;
            }
            for(int row = down; row >= up; row --){  // 最左边一列
                result.add(matrix[row][left]);
            }
            left ++;
            if(left > right){
                break;
            }
        }
        return result;
    }
}
