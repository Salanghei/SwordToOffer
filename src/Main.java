import cn.edu.hit.ices.yang.model.ListNode;
import cn.edu.hit.ices.yang.model.TreeNode;
import cn.edu.hit.ices.yang.problem.*;

import java.util.ArrayList;

public class Main {
    private static Permutation permutation = new Permutation();

    // 测试
    public static void main(String[] args) {
        ArrayList<String> test = permutation.solution("abc");
        for(String str : test){
            System.out.println(str);
        }
    }
}
