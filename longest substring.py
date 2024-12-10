# TC: O(n)
# SC: O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chSet = set()
        count = 0
        slow = 0
        for i in range(len(s)):
            if s[i] in chSet:
                while s[slow] != s[i]:
                    chSet.remove(s[slow])
                    slow += 1
                slow += 1
            
            chSet.add(s[i])
            count = max(count, i-slow+1)
        return count

