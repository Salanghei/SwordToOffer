package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P，并将P对1000000007取模的结果输出，即输出P%1000000007
 *
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 	解题思路：归并排序，同时统计逆序对数
 */
public class InversePairs {
    private int count = 0;

    public int solution(int[] array){
        mergeCore(array, 0, array.length - 1);
        return count;
    }

    private void mergeCore(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeCore(array, low, mid);
        mergeCore(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high){
        int iLeft = low, iRight = mid + 1, index = 0;
        int[] temp = new int[high - low + 1];
        while (iLeft <= mid && iRight <= high){
            if(array[iLeft] > array[iRight]){
                count = (count + (mid - iLeft + 1)) % 1000000007;       // 左侧比当前数大的数，都比右侧的当前数大
                temp[index ++] = array[iRight ++];
            }else{
                temp[index ++] = array[iLeft ++];
            }
        }
        while(iLeft <= mid){
            temp[index ++] = array[iLeft ++];
        }
        while(iRight <= high){
            temp[index ++] = array[iRight ++];
        }
        for(int i = 0; i < temp.length; i ++){
            array[low + i] = temp[i];
        }
    }
}
