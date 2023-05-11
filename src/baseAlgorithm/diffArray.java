package baseAlgorithm;

import java.util.Scanner;

public class diffArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int[][] operator = new int[m][3];
        for(int j = 0;j<m;j++){
            operator[j][0] = sc.nextInt();
            operator[j][1] = sc.nextInt();
            operator[j][2] = sc.nextInt();
        }
        diff(nums,operator);
        for(int i=0;i<n;i++){
            System.out.printf(nums[i]+" ");
        }
    }
    public static void diff(int[] nums, int[][] operator){
        int[] diff = new int[nums.length];
        for(int i=0;i<operator.length;i++){
            diff[operator[i][0]-1] += operator[i][2];
            if(operator[i][1]<nums.length) {
                diff[operator[i][1]] -= operator[i][2];
            }
        }
        int val = 0;
        for(int i=0;i<nums.length;i++){
            diff[i] += val;
            nums[i] += diff[i];
            val = diff[i];
        }
    }
}
