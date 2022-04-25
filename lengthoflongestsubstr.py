class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        maxi = 0;
        slow = 0;
        for element in range(len(s)):
            if s[element] in seen:
                slow = max(slow, seen[s[element]])
            maxi = max(element + 1 - slow, maxi)
            seen[s[element]] = element + 1
        return maxi;
        
