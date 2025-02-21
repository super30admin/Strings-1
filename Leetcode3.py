#Time Complexity= O(n)
#Space complexity = O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
       l = 0
       hashset = set()
       res = 0
       for r in range(len(s)):
            while s[r] in hashset:
                hashset.remove(s[l])
                l += 1
            hashset.add(s[r])
            res = max(res, r-l +1)
       return res

          
           


        