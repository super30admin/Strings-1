# Time O(2n)
# Space O(26)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow, fast = 0, 0
        cset = set()
        maxLen = 0
        while fast < len(s):
            if s[fast] in cset:
                while s[slow] != s[fast]:
                    cset.remove(s[slow])
                    slow += 1
                slow += 1
            cset.add(s[fast])
            maxLen = max(maxLen, fast - slow + 1)
            fast += 1
        return maxLen

# Time O(n)
# Space O(26)    
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow, fast = 0, 0
        cmap = defaultdict(lambda:-1)
        maxLen = 0
        while fast < len(s):
            if s[fast] in cmap:
                slow = max(slow, cmap[s[fast]] + 1)
            cmap[s[fast]] = fast
            maxLen = max(maxLen, fast - slow + 1)
            fast += 1
        return maxLen