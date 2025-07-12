package Dp.One_D;

public class House_Robber {
    public static int maxLoot(int[] home, int i, int[] dp){
        if(i==0) return home[i];
        else if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = maxLoot(home,i-2,dp) + home[i];
        int notPick = maxLoot(home,i-1,dp);
        return dp[i] = Math.max(pick,notPick);
    }

    // tabulation
    public static int max(int[] home){
        int[] dp = new int[home.length];
        dp[0] = home[0];
        for(int i=1; i<home.length; i++){
            int pick = home[i];
            if(i>1) pick+= dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[dp.length-1];
    }
}
