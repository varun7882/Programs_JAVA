package varun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
/**
 *
 * @author joni
 */
public class testcpath {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new java.io.BufferedInputStream(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = in.nextInt();
        int K = in.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; ++i) {
            A[i]=in.nextInt();
        }
        System.out.println(minimalProduct(N,K,A));
    }
 
    static int minimalProduct(final int N, final int K, int[] A) {
        double[] dp = new double[N];
        int[] jumps = new int[N];
        dp[N-1] = log(A[N-1]);
        jumps[N-1] = N; // to break last loop
        TreeMap<Double,Integer> findMin = new TreeMap<>();
        for (int j=N-2; j>=0; --j) {
            
            if (j+K+1<N && findMin.get(dp[j+K+1]) == j+K+1) findMin.remove(dp[j+K+1]);
            findMin.put(dp[j+1], j+1);
            Map.Entry<Double, Integer> firstEntry = findMin.firstEntry();
            double minProd = firstEntry.getKey();
            int minJump = firstEntry.getValue();
           
            dp[j] = log(A[j])+minProd;
            jumps[j] = minJump;
        }
        long product = 1;
       /* for (int j=0; j<N; j++) {
            System.out.println(j+" jumps "+jumps[j]);
        }*/
        for (int j=0; j<N; j = jumps[j]) {
        	System.out.println(A[j]);
            product = (product*A[j]) % 1000000007;
        }
        return (int) product;
    }
 
    private static double log(double d) {
       return Math.log(d);
    }
}