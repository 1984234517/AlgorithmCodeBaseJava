package baseAlgorithm;

import java.util.Scanner;

public class smallNumberDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int div = sc.nextInt();
        int[] nums1 = new int[s1.length()];
        for(int i=0;i<s1.length();i++){
            nums1[i] = s1.charAt(i)-'0';
        }
        int[] res = division(nums1, div);
        int i = 0;
        while(i<res.length-2 && res[i]==0){
            i++;
        }
        for(;i<res.length-1;i++){
            System.out.print(res[i]);
        }
        System.out.printf("\n");
        System.out.print(res[res.length-1]);
    }
    public static int[] division(int[] nums1,int div){
        int n = nums1.length;
        // 结果数组，前n个数字表示商，最后一个元素表示余数
        int[] res = new int[n+1];
        int val = 0;
        for(int i=0;i<n;i++){
            val = val*10+nums1[i];
            res[i] = val/div;
            val%=div;
        }
        // 添加余数
        res[n] = val;
        return res;
    }
    
}
