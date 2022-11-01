"""
Given a string s, find the length of the longest substring without repeating characters.

Approach --
1. Place the pointer slow and fast = 0
2. Create a hashMap of characters in a sting, move fast pointer and add respective character in hashMap with key as character and value as index + 1.
3. Everytime we move the fast pointer check if the character is present in hashMap.
4.If it is present, get its corresponding value from hashMap and move the slow pointer to the max(hashMap value , slow pointer's value). Maximum value because the character we are checking should be between range of current sliding window.
5. Calculate the maximum length as fast-slow + 1

TC - O(n)
SC - O(1) --> since only 26 alphabets
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0: return 0

        map = {}

        maxLen = 0
        slow = 0

        for i in range(len(s)):
            c = s[i]
            if map.get(c):
                slow = max(slow, map[c])

            map[c] = i + 1

            maxLen = max(maxLen, i - slow + 1)

        return maxLen





