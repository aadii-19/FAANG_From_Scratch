package Stack_Queue;

import java.util.ArrayList;

public class Remove_K_Digit {
    public static void main(String[] args) {
        String str = "1432219";
        int k = 3;
        System.out.println(removeK(str,k));
    }
    public static String removeK(String str, int k){
        // "1432219"
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            while(!list.isEmpty() && k>0 && list.get(list.size()-1)> str.charAt(i)){
                list.remove(list.size()-1);
                k-=1;
            }
            list.add(str.charAt(i));
        }
        while(!list.isEmpty() && k>0){
            list.remove(list.size()-1);
            k-=1;
        }
        if(list.isEmpty()) return "0";
        StringBuilder st = new StringBuilder();
        for (char character : list) {
            st.append(character);
        }
        int i =0;
        while(i<st.length() && st.charAt(i)=='0'){
            i+=1;
        }
        String res = st.substring(i);
        return res.isEmpty() ? "0" : res;
    }
}

/*
402. Remove K Digits
Solved
Medium
Topics
premium lock icon
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.

 */
