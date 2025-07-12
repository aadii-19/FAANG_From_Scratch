package Dp.One_D;

import java.util.Arrays;

public class Climbing_Stairs {
    public static void main(String[] args) {
        int[] dp = new int[4];
        int[] dp2 = new int[5];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);
        System.out.println(getCount(3,dp));
        System.out.println(generalCount(4,4,dp2));
    }

    public static int getCount(int n, int[] dp){
        if(n==0) return 1;
        else if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = getCount(n-1,dp) + getCount(n-2,dp);
    }

    // for k different ways
    public static int generalCount(int n, int k, int[] dp){
        if(n==0) return 1;
        else if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int total_ways = 0;
        for(int i=1; i<=k; i++){
            total_ways += generalCount(n-i,k,dp);
        }
        return dp[n] = total_ways;
    }
}
