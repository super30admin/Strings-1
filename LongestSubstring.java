/*

TC: O(N) - N - length of String
SC: O(min(N,M)) N - length of String, M - uniques chars in the string

1. Keep two pointers start and end.
2. Update the index of char in hashmap with end + 1.
3. Calculate maxLen at every step. 
4. When we encounter a char already present in string, move the start pointer. 

*/

import java.util.*;
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c));
            }
            map.put(c , end + 1);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        
        return maxLen;
    }

    public static void main(String[] args){
        String S = "abcabcdb";
        LongestSubstring LS = new LongestSubstring();
        System.out.println(LS.lengthOfLongestSubstring(S));

    }
}
