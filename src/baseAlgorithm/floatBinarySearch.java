package baseAlgorithm;

import java.util.Scanner;

public class floatBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double val = BinarySearch(n);
        System.out.println(String.format("%.6f", val));
    }
    public static double BinarySearch(double n){
        double l = 0,r=10000000;
        double mid;
        double res = 0;
        double val = Math.abs(n);
        while(r-l>0.00000005){
            mid = l+(r-l)/2;
            if (mid * mid * mid >= val) {
                r = mid;
                res = mid;
            }else{
                l = mid;
            }

        }
        if(n<0){
            return -res;
        }
        return res;
    }
}
