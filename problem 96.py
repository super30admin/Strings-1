# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        end = 0
        max_ans = 0
        hs = set()
        while start < len(s) and end < len(s):
            ch = s[end]
            while ch in hs:
                hs.remove(s[start])
                start += 1
            hs.add(ch)
            max_ans = max(max_ans, end - start + 1)
            end+=1
        return max_ans        

# TC: O(n)
#SC: O(k) k is the length of the ans