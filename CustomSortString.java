// Time Complexity : O(s*t); s--> length of string s; t-> length of string T
// Space Complexity : O(t); 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : Used a hashmap for mapping the characters and respective counts in T string.
// Iterated over S string and appended the characters in a stringbuilder whichever were found in S.
// Appended rest of the characters from map. Since the counts were being decremented on each addition in stringbuilder, it is guaranteed that all characters will be covered without duplication.
/*
class Solution {
    public String customSortString(String S, String T) {
        if(S == null || T == null) return null;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        char[] str = S.toCharArray();
        for(char ch : str) { // O(s)
            if(map.containsKey(ch) && map.get(ch) > 0) {
                while(map.get(ch) > 0) { // O(t) -> worst case
                    sb.append(ch);
                    map.put(ch, map.get(ch)-1);
                }
            }
        }
        for(char ch : map.keySet()) {
            while(map.get(ch) > 0) {
                sb.append(ch);
                map.put(ch, map.get(ch)-1);
            }
        }
        return sb.toString();
    }
}
*/

// Time Complexity : O(s*t)
// Space Complexity : O(1); constant space used by integer array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : Replaced the map from above approach to integer array mapping.
// Modularized the code by creating a new function for repetitive steps.

class Solution {
    public String customSortString(String S, String T) {
        if(S == null || T == null) return null;
        int[] chars = new int[26];
        for(int i = 0; i < T.length(); i++) {
            chars[T.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(chars[ch-'a'] > 0) {
                append(sb, chars, ch);
            }
        }
        for(char ch = 'a'; ch <= 'z'; ch++) {
            append(sb, chars, ch);
        }
        return sb.toString();
    }
    
    private void append(StringBuilder sb, int[] chars, char ch) {
        while(chars[ch-'a'] > 0) {
            sb.append(ch);
            chars[ch-'a']--;
        }
    }
}


