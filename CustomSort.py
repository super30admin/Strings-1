"""
Time Complexity : O(n) where n if length of string s
Space Complexity : O(1) hashmap would contain only limited strings i.e 26 chars
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if len(s) == 0:
            return ""
        result = ""
        # Count the frequency of the characters in string s
        freqCount = collections.Counter(s)
        # Traverse through the characters in string order and add the char to result 
        # string multiplying by its frequency of characters
        for char in order:
            if char in freqCount:
                result += char * freqCount[char]
                freqCount[char] = 0
        # Add remaining characters from string s to the result string
        for char in freqCount:
            result += char * freqCount[char]
        return result
                