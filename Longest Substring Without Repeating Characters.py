# Time Complexity :
# TC: O(L) --> L is length of string s

# Space Complexity :
# SC: O(1) --> O(26)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# I used hashmap and sliding window technique to solve this problem.
# The comments in program are step by step description.


class Solution:
    
    # Using slinding window and hashmap
    # TC: O(L) --> L is length of string s
    # SC: O(1) --> O(26)
    
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        maximum = 0
        hashMap = dict()
        low = 0
        
        for i in range(len(s)):
            char = s[i]
            
            if (hashMap.get(char, None)):
                low = max(hashMap.get(char, None), low)
                
            hashMap[char] = i + 1
            maximum = max(maximum, i - low + 1)
            
        return maximum