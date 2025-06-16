package Recursion;

public class Sum_of_N {
    public static void main(String[] args) {
        System.out.println(solution(3));
        solution2(3,0);
    }
    //    static int sum = 0; // Here a global declaration is not appreciated coz sum tend to accumulate over other calls
    // In the print from N -> 1 the global worked because we were also backtracking the global thus bringing it back to it's original state 1.
    public static int solution(int n){
        if(n==1){
            return 1;
        }
        return n+solution(n-1);
    }

    public static void solution2(int i, int sum){  // This is a parameterised function
        if(i<1){
            System.out.println(sum);
            return;
        }
        solution2(i-1,sum+i);
    }
}
