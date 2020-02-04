package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 *
 * 解题思路：
 * 回溯算法
 */
public class MovingCount {
    private int count = 0;
    private int[][] visited;
    public int solution(int threshold, int rows, int cols){
        if(threshold < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        visited = new int[rows][cols];
        find(threshold, rows, cols, 0, 0);
        return count;
    }

    private void find(int threshold, int rows, int cols, int row, int col){
        int rowTemp = row, colTemp = col, sum = 0;
        while(rowTemp > 0){
            sum = sum + rowTemp % 10;
            rowTemp = rowTemp / 10;
        }
        while(colTemp > 0){
            sum = sum + colTemp % 10;
            colTemp = colTemp / 10;
        }
        if(row < 0 || row >= rows || col < 0 || col >= cols || sum > threshold || visited[row][col] == 1){
            return;
        }
        count ++;
        visited[row][col] = 1;
        find(threshold, rows, cols, row - 1, col);
        find(threshold, rows, cols, row + 1, col);
        find(threshold, rows, cols, row, col - 1);
        find(threshold, rows, cols, row, col + 1);
    }
}
