package Dp.One_D;

public class Frog_Jump {
    public int minCost(int[] height, int i, int[] dp){
        if(i==0){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int oneStep = Integer.MAX_VALUE;
        int twoStep = Integer.MAX_VALUE;
        oneStep = minCost(height,i-1,dp) + Math.abs(height[i]-height[i-1]);
        if(i>1) twoStep = minCost(height,i-2,dp) + Math.abs(height[i]-height[i-2]);
        return dp[i] = Math.min(oneStep,twoStep);
    }
}
