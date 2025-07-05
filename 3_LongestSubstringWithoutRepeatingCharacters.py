"""
TC: O(N)
SC: O(26) ~O(1)
Logic:
Use 2 pointer method.
Check if element was encountered before. If yes, adjust start else update max_len
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        r = 0
        start = 0
        max_len = 0
        map = {}
        while(r<len(s)):
            if s[r] not in map or map.get(s[r])<start:
                max_len = max(max_len, r-start+1)
            else:
                start = map.get(s[r])+1
            map[s[r]]=r
            r+=1
        return max_len