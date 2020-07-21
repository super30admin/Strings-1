# Time Complexity : O(n) [n=length of s-> 2n to be precise]
# Space Complexity : O(1) [set has only a fixed number of ascii char, so constant space]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem approach
# 1. Use a set to keep track of the unique charatcters
# 2. Use two pointers start and end to traverse the string
#   2.1 Increment end if the char is not in set and update the max_count
#   2.2 Increment start id char is in set and remove s[start] from set
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:return 0
        
        start, end = 0,0
        max_count = 1
        n = len(s)
        char_set = set()
        while start < n and end < n:
            if s[end] not in char_set:
                char_set.add(s[end])
                end+=1
                max_count = max(end-start, max_count)
            else:
                char_set.remove(s[start])
                start+=1
        return max_count