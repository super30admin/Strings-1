"""
    Time : O(N)
    Space = O(N) -> no of unique character
    Leetcode : yes
    Explanation : Solve through sliding window, remove from start when end is in memory
        add end when end not in memory.
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        start, end, mlen  = 0, 0, 0
        mem = set()
        while end < len(s):
            
            end_char = s[end]
            
            if end_char not in mem:                
                end += 1
                mem.add(end_char)
                if end - start >= mlen:
                    mlen = end - start 
            else:
                start_char = s[start]
                mem.remove(start_char)
                start += 1

        return mlen
                