package baseAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

// 由于这个减法允许负数出现，所以这里需要额外判断，当前的结果是正数还是负数
public class bigNumberSub {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String arr1 = sc.next();
            String arr2 = sc.next();
            // 由于这个减法允许负数出现，所以这里需要额外判断，当前的结果是正数还是负数
            boolean type = juge(arr1,arr2);
            ArrayList<Integer> res;
            if(!type)
                res = bigNumberSubTest(arr1,arr2);
            else
                res = bigNumberSubTest(arr2,arr1);
            if(type){
                System.out.print("-");
            }
            int i = res.size()-1;
            while(i>-1 && res.get(i)==0){
                i--;
            }
            if(i==-1){
                System.out.print("0");
            }
            for(;i>-1;i--){
                System.out.print(res.get(i));
            }
        }
        public static ArrayList<Integer> bigNumberSubTest(String arr1,String arr2){
            ArrayList<Integer> res = new ArrayList<>();
            int index = 0;
            for(int i=arr1.length()-1,j=arr2.length()-1;i>-1;i--,j--){
                index += arr1.charAt(i)-'0';
                if(j>-1){
                    index -= arr2.charAt(j)-'0';
                }
                res.add((index+10)%10);
                index = index<0?-1:0;
            }
            return res;
        }
        public static boolean juge(String arr1,String arr2){
            if(arr1.length()<arr2.length()){
                return true;
            }else if(arr1.length()>arr2.length()){
                return false;
            }else{
                for(int i=0;i<arr1.length();i++){
                    if(arr1.charAt(i)>arr2.charAt(i)){
                        return false;
                    }else if(arr1.charAt(i)<arr2.charAt(i)){
                        return true;
                    }
                }
            }
            return false;
        }

}
