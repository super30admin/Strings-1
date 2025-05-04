# Time Complexity : O(n)
# Space Complexity : O(n)

# Approach:
# 1. Create a counter for the string s to count the frequency of each character.
# 2. Iterate through the order string and for each character, if it exists in the counter, append it to the result string as many times as its frequency in s.
# 3. After processing the order string, check if there are any remaining characters in the counter that were not in the order string.
# 4. Append these remaining characters to the result string in any order.

import collections
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Initialize an empty string to store the result
        res = ''
        # Create a counter for the string s to count the frequency of each character
        sCount = collections.Counter(s)
        # Iterate through the order string
        for c in order:
            # If the character exists in the counter, append it to the result string as many times as its frequency in s
            # and remove it from the counter
            if c in sCount:
                for i in range(sCount[c]):
                    res += c
                    sCount[c] -= 1
                    if sCount[c] == 0:
                        del sCount[c]
        # After processing the order string, check if there are any remaining characters in the counter
        # that were not in the order string
        if len(sCount) != 0:
            # Append these remaining characters to the result string in any order
            for key, val in sCount.items():
                for i in range(val):
                    res += key
        # Return the result string
        return res