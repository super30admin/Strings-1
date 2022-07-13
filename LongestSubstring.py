#3. Longest Substring Without Repeating Characters
"""
Time Complexity : O(n) 
Space Complexity : O(1) #O(26)
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = dict()
        slow =  0
        f = 0
        m = 0

        for i in range(0, len(s)):
            
            if s[i] not in d:
                d.update({s[i] : i})
                
            else:
                slow = max(slow, d.get(s[i]) + 1)
                d.update({s[i] : i})
            #print(d, slow, i)
            
            m  = max(m, i - slow + 1)
            
        return m
