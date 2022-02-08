#O(n) time and O(1) solution
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == "":
            return 0
        start = 0
        end = 0
        maximumLength = 0
        
        unique_characters = set()
        while end < len(s):
            if s[end] not in unique_characters:
                unique_characters.add(s[end])
                end += 1
                maximumLength = max(maximumLength, len(unique_characters))
            else:
                unique_characters.remove(s[start])
                start += 1
        return maximumLength