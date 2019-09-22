class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Time Complexity : O(n) because we are iterating through every character in the string
        # Space Complexity : O(n) because we have a hashmap which stores all the unique characters of string s
        # We can use a constant space if we have an array of size 256 and use that to store the index of the character from string s
        res = 0
        slow = 0
        fast = 0
        chardict = dict()
        while fast < len(s):
            if s[fast] in chardict:
                slow = max(slow, chardict[s[fast]])
            chardict[s[fast]] = fast + 1
            res = max(res, fast - slow + 1)
            fast += 1
        return res