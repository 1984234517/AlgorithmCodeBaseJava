package baseAlgorithm;

import java.util.Scanner;

public class BinarySearchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int[] query = new int[m];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            query[i] = sc.nextInt();
        }
        int[][] res = binarySearch(nums,query);
        for(int i=0;i<res.length;i++){
            System.out.printf(res[i][0]+" "+res[i][1]+"\n");
        }
    }
    public static int[][] binarySearch(int[] nums,int[] query){
        int n = query.length;
        int[][] res = new int[n][2];
        for(int i=0;i<n;i++){
            res[i] = Search(nums,query[i]);
        }
        return res;
    }
    public static int[] Search(int[] nums,int key){
        int[] res = new int[2];
        res[0]=-1;
        res[1]=-1;
        int l=0,r=nums.length-1;
        int mid;
        while(l<=r){
            mid = l+(r-l>>1);
            if(nums[mid]>=key){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        if(l<nums.length && nums[l]==key){
            res[0] = l;
        }else{
            return res;
        }
        l=0;
        r = nums.length-1;
        while(l<=r){
            mid = l+(r-l>>1);
            if(nums[mid]<=key){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        if(r >= 0 && nums[r]==key){
            res[1] = r;
        }
        return res;
    }
}
