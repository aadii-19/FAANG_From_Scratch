package Recursion;

public class Print_from_NToOne {

    public static void main(String[] args) {
        re(5);
        re(4);
    }

    // This method doesn't use the traditional fun(n-1) method
    // It uses one variable and is dependent on the global static variable a for functions

    static int a = 1;

    private static void re(int i) {
        if(a==i){
            System.out.println(a);
            return;
        }
        a+=1;
        re(i);
        a-=1;
        System.out.println(a);
    }
}
