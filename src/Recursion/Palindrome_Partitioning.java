package Recursion;

import java.util.ArrayList;
import java.util.List;


public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> res = palindrome(s);
        System.out.println(res);
    }

    public static List<List<String>> palindrome(String s){
        List<List<String>> res = new ArrayList<>();
        helper(s,0,res,new ArrayList<>());
        return res;
    }

    public static void helper(String s, int start, List<List<String>> res, List<String> list){
        if(start==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<s.length(); i++){
            String sub = s.substring(start,i+1);
            if(isValid(sub)){
                list.add(sub);
                helper(s,i+1, res, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean isValid(String s){
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
