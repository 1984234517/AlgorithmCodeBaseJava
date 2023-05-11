package baseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bigNumberAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr1 = sc.nextLine();
        String arr2 = sc.nextLine();
        List<Integer> nums1 = new ArrayList<>(arr1.length());
        List<Integer> nums2 = new ArrayList<>(arr2.length());
        for(int i=0;i<arr1.length();i++){
            nums1.add(i, arr1.charAt(arr1.length()-1-i)-'0');
        }
        for(int i=0;i<arr2.length();i++){
            nums2.add(i,arr2.charAt(arr2.length()-1-i)-'0');
        }
        List<Integer> res = add(nums1,nums2);
        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i));
        }
    }
    public static List<Integer> add(List<Integer>  arr1, List<Integer> arr2){
        if(arr1.size()<arr2.size()){
            return add(arr2,arr1);
        }
        int index = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<arr1.size();i++){
            index += arr1.get(i);
            if(i<arr2.size()){
                index += arr2.get(i);
            }
            res.add(index%10);
            index /=10;
        }
        if(index != 0){
            res.add(index);
        }
        return res;
    }
}
