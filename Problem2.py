# TC = O(n) | SC = O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str, ) -> int:
        if (s == None or len(s) == 0):
            return 0

        maxLength = 0
        start = 0
        end = 0
        elementsPresent = set()

        while (end < len(s)):

            while (s[end] in elementsPresent):
                elementsPresent.remove(s[start])
                start += 1

            elementsPresent.add(s[end])
            maxLength = max(maxLength, end - start + 1)
            end += 1

        return maxLength