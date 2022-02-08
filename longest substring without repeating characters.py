# Time Complexity - O(n)
# Space Complexity - O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = {}
        count = 0
        slow = 0
        for i in range(len(s)):
            if s[i] in hmap:
                slow = max(slow,hmap[s[i]])
            count = max(count,i-slow+1)
            hmap[s[i]]=i+1
        return count
