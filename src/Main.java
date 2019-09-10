import cn.edu.hit.ices.yang.problem.*;

public class Main {
    private static TwoDArraySearch twoDArraySearch = new TwoDArraySearch();

    // 测试
    public static void main(String[] args) {
        int[][] testArray = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(twoDArraySearch.Find(testArray, 20));
        System.out.println(twoDArraySearch.Find(testArray, 7));
    }
}
