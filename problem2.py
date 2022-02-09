# Time Complexity : O(n)
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s)==0:
            return 0

        slow = 0
        fast = 0
        _max = 0
        hashMap = {}

        while fast < len(s):
            if s[fast] in hashMap:
                    slow = max(hashMap[s[fast]],slow)

            hashMap[s[fast]] = fast+1
            _max = max(_max,fast-slow+1)
            fast += 1
        return _max


