class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        max1 = 0
        hmap = {}

        for i in range(len(s)):
            char = s[i]
            if char in hmap and slow <= hmap[char]:
                slow = hmap[char]+1
            else:
                max1 = max(max1,i-slow+1)
            hmap[char] = i
        return max1

        
        
        