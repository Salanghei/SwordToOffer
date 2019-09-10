package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 解题思路：
 * 二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
 * 因此从右上角开始查找：
 *     当要查找数字比右上角数字大时，下移；
 *     当要查找数字比右上角数字小时，左移；
 *     如果出了边界，则说明二维数组中不存在该整数。
 */
public class TwoDArraySearch {
    public boolean Find(int[][] array, int taget){
        if(array != null || array.length > 0 || array[0].length > 0){
            int row = 0;
            int column = array[0].length - 1;
            while (row < array.length && column >= 0){
                if(array[row][column] == taget){
                    return true;
                }else if(array[row][column] > taget){
                    column --;
                }else{
                    row ++;
                }
            }
        }
        return false;
    }
}
