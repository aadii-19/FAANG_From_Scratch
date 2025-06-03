package SlidingWindow;

import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k){
        int left = 0, right=0, maxLen = 0, maxFreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            char rchar = s.charAt(right);
            map.put(rchar,map.getOrDefault(rchar,0)+1);
            maxFreq = Math.max(maxFreq,map.get(rchar));
            while((right-left+1)-maxFreq>k){
                char lchar = s.charAt(left);
                map.put(lchar,map.get(lchar)-1);
                if(map.get(lchar)==0){
                    map.remove(lchar);
                }
                left+=1;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right+=1;
        }
        return maxLen;
    }
}

/*
How to approach ??
--> 1. Keep a hashmap or array(better) to track the elements
--> 2. Keep a maxFreq variable to track the maxFreq in the window
--> 3. Now we can know whether the condition is satisfied as long as length of the window - maxFreq == k
--> 4. (right-left+1)-maxFreq == k is the condition
*/
/*
424. Longest Repeating Character Replacement
Solved
Medium
Topics
premium lock icon
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */
