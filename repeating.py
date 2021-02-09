# TC: O(N)
# SC: O(N)

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        char_map = {}
        i = 0
        max_len = 0
        
        for k, c in enumerate(s):
            if char_map.get(c, None) is not None and char_map[c] >= i:
                i = char_map[c] + 1
                char_map[c] = k
            else:
                char_map[c] = k
                max_len = max(max_len, k-i+1)
        return max_len