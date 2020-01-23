package cn.edu.hit.ices.yang.problem;

public class FirstAppearingOnce {
    private int[] count = new int[256];    // 字符出现的次数
    private int[] index = new int[256];    // 字符出现的最后一次索引
    private int number = 0;

    public void insert(char ch){
        count[ch] ++;
        index[ch] = number ++;
    }

    public char solution(){
        int minIndex = number;
        char ch = '#';
        for(int i = 0; i < 256; i ++){
            if(count[i] == 1 && index[i] < minIndex){
                ch = (char)i;
                minIndex = index[i];
            }
        }
        return ch;
    }
}
