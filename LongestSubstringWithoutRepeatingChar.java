// Time Complexity : O(n)
// Space Complexity : (k) where k is the size of biggest non repeating string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a HashMap with char and int as mapping
// Take 2 pointers if we see unique char then we put it in the map
// If the char is already there we will increment the start by as many times
// We will keep the max difference of start and end pointers every time
// We will have the answer in maxLen and we will return it.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        while(end < s.length()){
            char x = s.charAt(end);
            hm.put(x, hm.getOrDefault(x,0)+1);
            if(hm.containsKey(x))
            while(hm.get(x) > 1){
                char y = s.charAt(start);
                hm.put(y, hm.get(y)-1);
                start++;
            }
            end++;
            maxLen = Math.max(end - start, maxLen);   
        }
        return maxLen;
    }
}