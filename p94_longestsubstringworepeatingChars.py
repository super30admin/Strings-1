"""
TC: O(n)
sc:-O(1)- since there will always be 26 keys present in the hashmap
https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = {}
        slow = 0
        maximum = 0
        start = 0
        end = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                ###slow ko assign kiya max of slow
                slow = max(slow, hashmap[s[i]])

            if i - slow + 1 > maximum:
                maximum = i - slow + 1
                start = slow
                end = i

            # maximum=max(maximum, i-slow+1)

            hashmap[s[i]] = i + 1

        print(s[start:end + 1])
        return maximum


