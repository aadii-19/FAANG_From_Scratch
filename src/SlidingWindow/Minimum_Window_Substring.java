package SlidingWindow;

import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t){
        if(s.length()<t.length()) return "";
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int required = t.length();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        while(right<s.length()){
            char rchar = s.charAt(right);
            if(map.containsKey(rchar)){
                if(map.get(rchar)>0){
                    required-=1;
                }
                map.put(rchar,map.get(rchar)-1);
            }
            while(required==0){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char lchar = s.charAt(left);
                if(map.containsKey(lchar)){
                    map.put(lchar,map.get(lchar)+1);
                    if(map.get(lchar)>0){
                        required+=1;
                    }
                }
                left+=1;
            }
            right+=1;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}

/*
HOW TO APPROACH ??
--> 1. Keep a required so that we can track how much is required to satisfy the condition
--> 2. Load the t string into the hashmap and then start the while with right
--> 3. Once the required == 0 we'll start by shrinking the window from the left
--> 4. Always check for minLen and keep updating the minLen in every shrink
--> 5. When smaller minLen is found then assign start to that left since we have to return substring
--> 6. Now increase in hashmap and If count>0 then update required+=1.
--> 7. Now return the substring from start and start+minLen;
 */

/*
76. Minimum Window Substring
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
