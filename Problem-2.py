'''
    Time Complexity: O(2n)
    Space Complexity: O(1)
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)

        if n == 0:
            return 0

        slow, fast = 0, 0
        maxLen = 0
        hashMap = {}

        for fast in range(n):
            if s[fast] in hashMap and slow <= hashMap[s[fast]]:
                slow = hashMap[s[fast]] + 1
                
            hashMap[s[fast]] = fast
            maxLen = max(maxLen, fast - slow + 1)

        return maxLen