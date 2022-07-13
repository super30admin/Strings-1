#Time Complexity: O(2n)
#Space Complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        
        maxL, slow, fast = 0, 0, 1
        hSet = set()
        hSet.add(s[slow])
        
        while fast < len(s):
            ch = s[fast]
            if ch in hSet:
                while s[slow] != ch:
                    hSet.remove(s[slow])
                    slow += 1
                slow += 1
            maxL = max(maxL, fast-slow+1)
            hSet.add(ch)
            fast += 1
    
        return maxL
  
#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxL = 0
        slow = 0
        hMap = dict()
        
        for i in range(len(s)):
            if s[i] in hMap:
                slow = max(hMap[s[i]], slow)
            maxL = max(maxL, i - slow + 1)
            hMap[s[i]] = i + 1
    
        return maxL        
        
