# APPROACH 1: BRUTE FORCE
# Time Complexity : O(n^3), n: len(s)
# Space Complexity : O(1), max size of set if all chars in s is unique is 26
# Did this code successfully run on Leetcode : No (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Consider every possible substring (start pos vary from 0 to len(s) and end pos vary from start pos + 1 till end of s)
# 2. For each substr, go through it and store the unique char in set. If any char is repeated terminate search in that substr
# 3. If no char is repeated in that substr, keep track of the maximum length found so far.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) < 1:
            return 0
        
        max_len = 0
        for start in range(len(s)):
            for end in range(start + 1, len(s) + 1):
                
                if self.max_unique(s, start, end):
                    max_len = max(max_len, end - start)
                    
        return max_len
    
    def max_unique(self, s, start, end):
        unique_char = set()
        for ind in range(start, end):
            if s[ind] in unique_char:
                return False
            else:
                unique_char.add(s[ind])
            
        return True
        
        

# APPROACH 2: OPTIMAL APPROACH
# Time Complexity : O(n), n: len(s)
# Space Complexity : O(1), 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. 2 pointers - start, end (keep track of current longest substr) and also track max length found so far. 
# 2. For each char in s (shift end), if char is not in hashmap, simply store it along with it's ind in hashmap
# 3. If char is found in hashmap and is within the current window (ind >= start), update max length and start pos to the next ind of the earlier occurrence of char
# 4. there can be a case where the char was found in earlier window and it's entry still in hashmap and again found in the current window -> it's not invalid, just need to update
#    it's hashmap entry

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) < 1:
            return 0
        
        start, end, unique_char, max_len = 0, 0, {}, 0
        
        while end < len(s):
            if s[end] in unique_char and unique_char[s[end]] >= start:
                max_len = max(max_len, end - start)
                start = unique_char[s[end]] + 1
                
            unique_char[s[end]] = end
            end += 1
         
        max_len = max(max_len, end - start)
        return max_len
