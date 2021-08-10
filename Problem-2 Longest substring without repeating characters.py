#Time complexity:O(N)
#Space complexity:O(1)
class Solution:
    def lengthOfLongestSubstring(self, s) :

        if s == None or len(s) == 0:
            return 0
        n = len(s)
        hashmap = {}

        slow = 0
        maxLen = 0

        for i in range(0, n):
            ch = s[i]
            if ch in hashmap:
                slow = max(slow, hashmap[ch])
            hashmap[ch] = i + 1
            maxLen = max(maxLen, i - slow + 1)
        return maxLen
