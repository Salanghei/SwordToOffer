package cn.edu.hit.ices.yang.problem;


/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 解题思路：
 * 回溯算法
 */
public class HasPath {
    private int[][] visited;
    public boolean solution(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || str == null || rows <= 0 || cols <= 0 || matrix.length < str.length){
            return false;
        }
        char[][] array = new char[rows][cols];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                array[i][j] = matrix[i * cols + j];
            }
        }
        visited = new int[rows][cols];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(findPath(array, rows, cols, str, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[][] array, int rows, int cols, char[] str, int row, int col, int index){
        if(index >= str.length){
            return true;
        }
        if(row < 0 || row >= rows || col < 0 || col >= cols
                ||  array[row][col] != str[index] || visited[row][col] == 1){
            return false;
        }
        visited[row][col] = 1;
        boolean result = findPath(array, rows, cols, str, row - 1, col, index + 1)
                || findPath(array, rows, cols, str, row + 1, col, index + 1)
                || findPath(array, rows, cols, str, row, col - 1, index + 1)
                || findPath(array, rows, cols, str, row, col + 1, index + 1);
        visited[row][col] = 0;
        return result;
    }
}
