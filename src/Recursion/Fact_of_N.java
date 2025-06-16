package Recursion;


public class Fact_of_N {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n){
        if(n==1) return 1;
        return n*solution(n-1);
    }
}
