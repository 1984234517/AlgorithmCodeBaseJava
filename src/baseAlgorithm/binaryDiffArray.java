package baseAlgorithm;

import java.util.Scanner;

public class binaryDiffArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] nums = new int[n][m];
        int val;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                val = sc.nextInt();
                add(nums,i,j,i,j,val);
            }
        }
        for(int i=0;i<q;i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();;
            int y2 = sc.nextInt();
            val = sc.nextInt();
            add(nums,x1-1,y1-1,x2-1,y2-1,val);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int value = 0;
                if(i>0)
                    value += nums[i-1][j];
                if(j>0)
                    value += nums[i][j-1];
                if(i>0 && j>0)
                    value -= nums[i-1][j-1];
                nums[i][j] += value;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void  add(int[][] nums,int x1,int y1,int x2,int y2,int val){
        nums[x1][y1] += val;
        if(y2+1<nums[0].length)
            nums[x1][y2+1] -= val;
        if(x2+1<nums.length)
            nums[x2+1][y1] -= val;
        if(x2+1<nums.length && y2+1<nums[0].length)
            nums[x2+1][y2+1] += val;
    }
}
