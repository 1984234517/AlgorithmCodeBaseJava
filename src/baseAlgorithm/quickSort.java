package baseAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class quickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        quickSortTest(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSortTest(int[] nums,int l,int r){
        if(l>=r){
            return ;
        }
        int x = nums[l+r>>1];
        int i=l-1,j=r+1;
        while(i<j){
            do i++;while (nums[i]<x);
            do j--;while (nums[j]>x);
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // 至于为什么这里需要使用j而不是用i，是因为上一个while循环出来后
        // i>j(为什么不是i>=j,因为这个while中，i和j都是同时加减的，所以有时会相差1，有时相等，
        // 所以出循环后，i和j并时时不相等)
        quickSortTest(nums,l,j);
        quickSortTest(nums,j+1,r);
    }
}
