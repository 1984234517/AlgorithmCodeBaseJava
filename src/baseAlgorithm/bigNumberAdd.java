package baseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bigNumberAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr1 = sc.nextLine();
        String arr2 = sc.nextLine();
        List<Integer> res = add(arr1,arr2);
        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i));
        }
    }
    public static List<Integer> add(String  arr1, String arr2){
        if(arr1.length()<arr2.length()){
            return add(arr2,arr1);
        }
        int index = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=arr1.length()-1,j=arr2.length()-1;i>-1;i--,j--){
            index += arr1.charAt(i)-'0';
            if(j>-1){
                index += arr2.charAt(j)-'0';
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
