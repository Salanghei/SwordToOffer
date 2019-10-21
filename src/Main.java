import cn.edu.hit.ices.yang.model.ListNode;
import cn.edu.hit.ices.yang.model.TreeNode;
import cn.edu.hit.ices.yang.problem.*;

public class Main {
    private static Convert convert = new Convert();

    // 测试
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node2.left = node1;
        node2.right = node3;
        node4.left = node2;
        node4.right = node5;

        convert.solution(node4);
    }
}
