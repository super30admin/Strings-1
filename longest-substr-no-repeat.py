# Time Complexity: O(N)
# Space Complexity: O(N)
# Approach: Initialize a window at start = 0 and end ranging over the remaining string characters while maintaining every character with it's index in a map. If the character already exists in the map, shrink the window by moving the start pointer to the index from the map + 1. At every iteration, the string contained in the window has non repeating characters - update a maxlen variable to keep track of the longest substring seen so far.
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start = 0
        index_map = collections.defaultdict(int)
        maxlen = 0
        
        for end in range(len(s)):
            end_char = s[end]
            
            if end_char in index_map:
                start = max(start, index_map[end_char] + 1)
            
            index_map[end_char] = end
            
            if end - start + 1 > maxlen:
                maxlen = end - start + 1
            
    
        return maxlen  