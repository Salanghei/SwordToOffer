import cn.edu.hit.ices.yang.model.TreeNode;
import cn.edu.hit.ices.yang.problem.SerializeTree;
import cn.edu.hit.ices.yang.problem.StrToInt;
import sun.reflect.generics.tree.Tree;


public class Main {
    private static SerializeTree serializeTree = new SerializeTree();

    // 测试
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node5.right = node1;
        node5.left = node2;
        TreeNode node6 = new TreeNode(6);
        node6.left = node3;
        node6.right = node4;
        TreeNode root = new TreeNode(7);
        root.left = node5;
        root.right = node6;
        String str = serializeTree.serialize(root);
        System.out.println(str);
        TreeNode node = serializeTree.deserialize(str);
        System.out.println(node.val);
    }
}
