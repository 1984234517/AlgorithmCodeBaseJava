package baseAlgorithm;

import java.util.Scanner;

public class bigNumberMul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] nums1 = new int[s1.length()];
        int[] nums2 = new int[s2.length()];
        for(int i=nums1.length-1;i>-1;i--){
            nums1[nums1.length-1-i] = s1.charAt(i)-'0';
        }
        for(int i=nums2.length-1;i>-1;i--){
            nums2[nums2.length-1-i] = s2.charAt(i)-'0';
        }
        int[] res =  mul(nums1,nums2);
        int i = res.length-1;
        while(i>0 && res[i] == 0){
            i--;
        }
        for(;i>-1;i--){
            System.out.print(res[i]);
        }
        System.out.printf("\n");
    }
    public static int[] mul(int[] nums1,int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1+l2];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                nums[i+j] = nums1[i]*nums2[j];
            }
        }
        for(int i=0;i<nums.length-1;i++){
            nums[i+1] += nums[i]/10;
            nums[i] %= 10;
        }
        return nums;
    }
}
