package Dp.One_D;

public class Frog_Jump_K {
    // Here the n should be given arr.length-1;
    public int getMin(int[] height, int n, int[] dp,int k){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1) return dp[n];
        int minCost = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
                int cost = getMin(height,n-i,dp,k) + Math.abs(height[n]-height[n-i]);
                minCost = Math.min(minCost,cost);
            }
        }
        return dp[n] = minCost;
    }
}
