#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dic = {}
        slow = 0
        maxm = 0
        for i in range(len(s)):
            if s[i] in dic:
                slow = max(slow,dic[s[i]])
            dic[s[i]] = i+1
            maxm = max(maxm,i-slow+1)
            
        return maxm
                
        