# Time Complexity : O(N) where N is length of the string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        longest = 0
        hashset = set()
        
        for end in range(len(s)):
            if s[end] not in hashset:
                hashset.add(s[end])
            else:
                while s[end] in hashset:
                    hashset.remove(s[start])
                    start += 1
                hashset.add(s[end])
                
            longest = max(longest, len(hashset))
        
        return longest