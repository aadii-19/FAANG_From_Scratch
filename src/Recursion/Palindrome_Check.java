package Recursion;

public class Palindrome_Check {
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(isCheck(str,0));
    }

    public static boolean isCheck(String str, int i){
        if(i>=str.length()/2) return true;
        if(str.charAt(i)!=str.charAt(str.length()-i-1)){
            return false;
        }
        return isCheck(str,i+1);
    }
}
