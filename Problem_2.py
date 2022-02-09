# Time Complexity : O(n)
# Space Complexity : O(1)
# running on leetcode : Yes
# Any problems faced while coding it out : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = {}
        Max, slow = 0, 0
        for i in range(len(s)):
            c = s[i]
            if c in hashmap.keys():
                slow= max(slow, hashmap.get(c))
            hashmap[c] = i+1
            Max = max(Max, i - slow + 1)
        return Max