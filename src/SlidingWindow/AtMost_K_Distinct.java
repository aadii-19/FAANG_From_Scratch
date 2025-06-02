package SlidingWindow;

import java.util.HashMap;

public class AtMost_K_Distinct {
    public int atMostK(String s, int k) {
        // Your logic here 👇
        int left = 0, maxLen=0;
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right=0; right< ch.length; right++){
            // add the right into map
            map.put(ch[right],map.getOrDefault(ch[right],0)+1);
            while(map.size()>k){
                map.put(ch[left],map.get(ch[left])-1);
                if(map.get(ch[left])==0){
                    map.remove(ch[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen; // Change this as needed
    }
}
