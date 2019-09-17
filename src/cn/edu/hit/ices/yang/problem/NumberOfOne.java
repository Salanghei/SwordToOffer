package cn.edu.hit.ices.yang.problem;

public class NumberOfOne {
    public int solution(int n){
        int count = 0;
        while(n != 0){
            count ++;
            n &= (n - 1);
        }
        return count;
    }
}
