package Recursion;

public class Fibonacci_Series {
    public static void main(String[] args) {

    }

    public static int printSeries(int n){
        int n1 = 0;
        int n2 = 1;

        for(int i=0; i<n; i++){
            int temp = n1+n2;
            n1 = n2;
            n2 = temp;
        }

        return n1;
    }
}
