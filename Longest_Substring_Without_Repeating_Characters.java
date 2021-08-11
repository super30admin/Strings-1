//3. Longest Substring Without Repeating Characters - https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Time Complexity : O(N)
// Space Complexity : O(1) bcz ASCII range is constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//using hashMap to store the character and its index
//using slow and fast pointer to find longest substring w/o repitition of characters in the string
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0, slow = 0;
        
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            //update slow pointer
            if(charMap.containsKey(ch)){
                slow = Math.max(slow, charMap.get(ch));
            }
        //update index
        charMap.put(ch, i+1);
        maxLen = Math.max(maxLen, i-slow+1);
    }
    
        return maxLen;
    }
}