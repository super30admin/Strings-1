#Time Complexity: O(n)
#Space Complexity: O(1)
#LeetCode: Yes

class Solution:
    def lengthOfLongestSubstring(self, s):
        mapper,max_,slow = {},0,0
        for i in range(len(s)):
            if s[i] in mapper:
                slow = max(slow, mapper[s[i]])
            mapper[s[i]] = i+1
            max_ = max(max_, i-slow+1)
        return max_

s = "abcabcbb"
obj = Solution()
print(obj.lengthOfLongestSubstring(s))
