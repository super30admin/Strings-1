// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        S = set()
        slow = 0
        Max = 0
        fast = 1
        if len(s)==0:
            return 0
        if len(s)==1:
            return 1
        S.add(s[slow])
        while fast<len(s):
            if s[fast] in S:
                while s[slow]!=s[fast]:
                    S.remove(s[slow])
                    slow+=1
                slow+=1
            Max = max(Max,fast-slow+1)
            S.add(s[fast])
            fast+=1
        return Max