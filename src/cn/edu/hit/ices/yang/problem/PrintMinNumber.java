package cn.edu.hit.ices.yang.problem;

/**
 * 题目描述：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 *
 * 解题思路：
 * 将numbers中的数从大到小排序，排序的规则如下：
 *     将每个数转为字符串，字符串固定长度为10，若不足10位，则后面用数的个数数字补齐，
 *     再按照字典序进行排序
 * 最后将排序好的数（原数）连接起来
 */
public class PrintMinNumber {
    public String Solution(int[] numbers){
        String format = "0000000000";
        for(int i = 0; i < numbers.length; i ++){
            for(int j = numbers.length - 1; j > i; j --){
                String num1Format = format.replaceAll("0", String.valueOf(numbers[j] % 10));
                String num1 = (String.valueOf(numbers[j]) + num1Format).substring(0, 10);
                String num2Format = format.replaceAll("0", String.valueOf(numbers[j - 1] % 10));
                String num2 = (String.valueOf(numbers[j - 1]) + num2Format).substring(0, 10);
                System.out.println(num1 + ", " + num2);
                if(num1.compareTo(num2) < 0){
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
        String result = "";
        for(int i = 0; i < numbers.length; i ++){
            result = result + numbers[i];
        }
        return result;
    }
}
