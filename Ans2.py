#  Time Complexity : O(n) 
#  Space Complexity : O(n) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : Use two pointers slow and fast both starting from index 0. Create a dictionary to store the characters of the fast pointer and its index + 1. Traverse through string s, add the unique char to the dictionary. If it is aready present in the dictionary move the slow pointer to the max value between the current index and value stored for that char in the dictionary. This will skip the repeating char. Add the present char to the dictionary. Maintain a max length for each cycle and at the end move the fast pointer ahead by 1.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        fast = 0
        slow = 0
        charDict = dict()

        while fast < len(s):
            if s[fast] in charDict:
                slow = max(slow, charDict[s[fast]])
            
            charDict[s[fast]] = fast + 1
            res = max(res, fast - slow + 1)
            fast += 1

        return res