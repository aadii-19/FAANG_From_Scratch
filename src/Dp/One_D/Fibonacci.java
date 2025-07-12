package Dp.One_D;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6,new int[7]));
        System.out.println(getFib(6));
    }
    public static int fib(int n, int[] visited){
        if(n<=1){
            visited[n] = n;
            return n;
        }
        if(visited[n]!=0){
            return visited[n];
        }
        // Time Complexity is O(N) but space Complexity is
        return visited[n] = fib(n-1,visited) + fib(n-2,visited);
    }

    // tabulation method
    public static int getFib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];   // this has both time and space complexity as O(N)
    }
}
