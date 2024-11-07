# 3. Longest Substring Without Repeating Characters
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_ = 0
        Set = set()
        slow = 0
        for i in range(len(s)):
            c = s[i]
            if c in Set:
                while s[slow] != c:
                    Set.remove(s[slow])
                    slow += 1
                slow += 1
            Set.add(c)
            max_ = max(max_,i-slow+1)

        return max_
        