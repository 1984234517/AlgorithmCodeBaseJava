package baseAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class bigNumberDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            nums1.add(s1.charAt(i)-'0');
        }
        for(int i=0;i<s2.length();i++){
            nums2.add(s2.charAt(i)-'0');
        }
        ArrayList<ArrayList<Integer>> res = bigNumberDivision(nums1, nums2);
        int i = 0;
        while(i<res.get(0).size()-1 && res.get(0).get(i) == 0){
            i++;
        }
        for(;i<res.get(0).size();i++){
            System.out.print(res.get(0).get(i));
        }
        System.out.printf("\n");
        i = 0;
        while(i<res.get(1).size()-1 && res.get(1).get(i) == 0){
            i++;
        }
        for(;i<res.get(1).size();i++){
            System.out.print(res.get(1).get(i));
        }
    }
    public static ArrayList<ArrayList<Integer>> bigNumberDivision(ArrayList<Integer> nums1, ArrayList<Integer> nums2){
        int l1 = nums1.size();
        int l2 = nums2.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        if(l1<l2){
            res.get(0).set(0,0);
            res.add(nums1);
        }
        int l = 0,r = l2-1;
        while(r<l1){
            // 求商同时从nums1中把减去nums2*quotient
            int quotient = getVal(nums1,l,r,nums2);
            res.get(0).add(quotient);
            while(l<=r && nums1.get(l)==0){
                l++;
            }
            r++;
        }
        res.add(nums1);
        return res;
    }
    public static int getVal(ArrayList<Integer> nums1,int l,int r,ArrayList<Integer> nums2){
        //商
        int left = 0,right = 9;
        int mid;
        // 判断当前的nums1[l,r]/nums2的最大商
        while(left<=right) {
            mid = left + (right - left >> 1);
            if (check(nums1, l, r, nums2, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        ArrayList<Integer> temp2 = new ArrayList<>(nums2);
        Mul(temp2,left-1);
        sub(nums1,l,r,temp2);
        return left-1;
    }
    public static boolean check(ArrayList<Integer> nums1,int l,int r,ArrayList<Integer> nums2,int val){
        if(val == 0){
            return true;
        }
        ArrayList<Integer> temp2 = new ArrayList<>(nums2);
        ArrayList<Integer> temp1 = new ArrayList<>(nums1);
        Mul(temp2,val);
        return sub(temp1,l,r,temp2);
    }
    public static void Mul(ArrayList<Integer> nums1,int val){
        for(int i=nums1.size()-1;i>-1;i--){
            if(i<nums1.size()-1) {
                nums1.set(i, nums1.get(i) * val+nums1.get(i+1)/10);
                nums1.set(i+1,nums1.get(i+1)%10);
            }else{
                nums1.set(i, nums1.get(i) * val);
            }
        }
        if(nums1.get(0)>9){
            nums1.add(0,nums1.get(0)/10);
            nums1.set(1,nums1.get(1)%10);
        }
    }
    public static boolean sub(ArrayList<Integer> nums1, int l, int r, ArrayList<Integer> nums2){
        int i=l;
        while(i<=r && nums1.get(i) == 0){
            i++;
        }
        if(r-i+1<nums2.size()){
            return false;
        }
        int count = 0;
        int index = nums2.size()-1;
        for(int j=r;j>=i;j--){
            count += nums1.get(j);
            if(index>-1){
                count -= nums2.get(index--);
            }
            nums1.set(j,(count+10)%10);
            if(count<0)
                count = -1;
            else
                count = 0;
        }
        if(count<0)
            return false;
        return true;
    }
}
