// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity : O(m+n)
// Space Complexity : O(1) - constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a hashmap with chars and frequencies. Iterate over s and when char is found then move slow pointer to max(slow,map.get(ch)+1), add
 * char with index to map and find the max length using max(max, i-slow+1). Finally, return max.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                slow = Math.max(slow, map.get(ch)+1);
            } 
            map.put(ch, i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }
}