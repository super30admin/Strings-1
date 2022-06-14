# Time Complexity : O(N) where N is length of the string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        end = 0
        longest = 0
        hashmap = {}
        i = 0
        while i < len(s):
            if s[i] in hashmap:
                    start = max(start, hashmap[s[i]] + 1)      
            hashmap[s[i]] = i
            longest = max(longest, end - start + 1)    
            end += 1
            i += 1
                
        return longest