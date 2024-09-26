#Time Complexity :O(N) where N is number of character in string
#Space Complexity : O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) ==0:
            return 0
        max1 = 0
        d = {}
        slow = 0
        for i in range(len(s)):
            c = s[i]
            if c in d:
                slow = max(slow,d.get(c))
            max1 =max(max1,i-slow+1)
            d[c] = i+1
        return max1
