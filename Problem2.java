// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use sliding window + hashing technique to find the longest substring
// We use HashMaps to store the character and its corresponding index
//If we encounter a duplicate char we move the left pointer to escape the char and update in hashmap
//We keep moving the right poiinter and keep noting the max length
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() <= 1) return s.length();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                //move the left pointer to escape that char
                left = Math.max(left, map.get(ch) + 1);

            }
            //add the char with its index to map and calculate the length
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
                
        }
        return maxLen;
        
    }
}
