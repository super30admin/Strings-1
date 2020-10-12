# Leetcode problem link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
# Time Complexity:    O(n) 
# Space Complexity:   O(n) for hashmap
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Set or hashmap can be used here to make sure the substring contains unique characters.
        Slow and fast or start and end will start from index 0
        Iterate while end is less than length
        Keep track of the max length of the substring seen so far
        add the index of current character to hash map. 
        If the current character exists in hashmap then our start/slow pointer will move to the next index (of the last occurrence of this character)
        Return the longest substring length
'''  
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        start = 0
        end = 0
        char_map = {}
        result = 0
        while end < len(s):
            
            if s[end] in char_map:
                start = max(char_map[s[end]],start)
            result = max(result,end-start+1)
            char_map[s[end]] = end + 1
            end += 1
        
        return result