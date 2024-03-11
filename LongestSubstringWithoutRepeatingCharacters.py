'''
TC: O(n) - number of letters in the input string
SC: O(1) - max the dictionary can have 26 characters
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        countdict = {}
        l = 0
        count = 0
        for r,v in enumerate(s):
            if v in countdict:
                if countdict[v] >= l:
                    l = countdict[v]+1
            countdict[v]=r
            count = max(count, r-l+1)
        return count
s = Solution()
print(s.lengthOfLongestSubstring("andyplayswithaball"))
print(s.lengthOfLongestSubstring("bbbbb"))
print(s.lengthOfLongestSubstring("pwwkew"))
print(s.lengthOfLongestSubstring("dvdf"))
print(s.lengthOfLongestSubstring("abcabcbb"))