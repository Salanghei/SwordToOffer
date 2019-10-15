package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
 * 如果是则输出Yes,否则输出No
 * 假设输入的数组的任意两个数字都互不相同
 *
 * 解题思路：
 * 后序遍历的顺序是左子节点、右子节点、根节点
 * 整棵树的遍历是递归的遍历左子树、右子树、根节点
 * 也就是说如果输入序列是某二叉搜索树的子树的后序遍历结果，那么最后一项应是根节点，
 * 前半部分应是左子树的后序遍历结果，其中的值都应小于最后一项
 * 后本部分应是右子树的后序遍历结果，其中的值都应大于最后一项
 * 分别从前往后和从后往前遍历序列：
 *     从前往后遍历时，比较当前元素与结尾元素的大小，若小于则继续，若大于则停止，此时得到的前部分序列即为左子树的后序遍历结果
 *     从后往前遍历时，比较当前元素与结尾元素的大小，若大于则继续，若小于则停止，此时得到的后部分序列即为右子树的后序遍历结果
 * 再递归的判断左右子树的序列是否是后序遍历结果
 */
public class VerifySquenceOfBST {
    public boolean solution(int[] sequence){
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return isSquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean isSquenceOfBST(int[] sequence, int left, int right){
        if(left >= right){
            return true;
        }
        int leftIndex = left, rightIndex = right - 1;
        boolean leftFlag = false, rightFlag = false;
        while(leftIndex <= right - 1 && rightIndex >= left){
            if(sequence[leftIndex] < sequence[right]){
                leftIndex ++;
            }else{
                leftFlag = true;
            }
            if(sequence[rightIndex] > sequence[right]){
                rightIndex --;
            }else{
                rightFlag = true;
            }
            if(leftFlag && rightFlag){
                break;
            }
        }
        if(leftIndex < rightIndex){
            return false;
        }
        return isSquenceOfBST(sequence, left, leftIndex - 1) && isSquenceOfBST(sequence, rightIndex + 1, right - 1);
    }
}
