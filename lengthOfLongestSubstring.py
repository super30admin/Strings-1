#TC: O(n)
#SC: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dict = {}
        start = 0 
        max_len = 0

        for end,v in enumerate(s):
            if v in dict:
                start = max(start, dict[v])
            dict[v] = end+1
            max_len = max(max_len, end-start+1)

        return max_len
