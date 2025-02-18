# time Complexity : O(n)
# space complexity : O(1) --- as number is 26
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        maximum = 0
        dictionary = {}
        for i in range(len(s)):
            if s[i] in dictionary:
                start = max(start, dictionary[s[i]])
            maximum = max(maximum, i - start +1)
            dictionary[s[i]] = i + 1
        return maximum
    
