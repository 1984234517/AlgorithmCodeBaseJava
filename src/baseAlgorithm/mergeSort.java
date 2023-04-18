package baseAlgorithm;

import java.util.Scanner;

public class mergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        mergeSortTest(nums,0,n-1);
        for(int i:nums){
            System.out.printf(i+" ");
        }
        System.out.println("\n");
    }
    public static void mergeSortTest(int[] nums,int l,int r){
        if(l>=r){
            return ;
        }
        mergeSortTest(nums,l,r+l>>1);
        mergeSortTest(nums, (l+r>>1)+1, r);
        int[] temp = new int[r-l+1];
        int i =l,j=(l+r>>1)+1;
        int k = 0;
        while(i<=(l+r>>1) && j<=r){
            if(nums[i]<nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i<=l+r>>1){
            temp[k++] = nums[i++];
        }
        while (j<=r){
            temp[k++] = nums[j++];
        }
        for(i=l;i<=r;i++){
            nums[i] = temp[i-l];
        }
    }
}
