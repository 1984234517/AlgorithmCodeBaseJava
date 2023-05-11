package baseAlgorithm;

import java.util.Scanner;

public class preSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[m+1];
        int[] res = new int[n];
        for(int i=1;i<=m;i++){
            nums[i] = nums[i-1]+sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            res[i] = nums[r]-nums[l-1];
        }
        for(int val:res){
            System.out.println(val);
        }
    }
}
