package Recursion;

public class Print_from_OneToN {
    public static void main(String[] args) {
        solution(5);
    }

    public static void solution(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        solution(n-1);
        System.out.println(n);
    }
}
