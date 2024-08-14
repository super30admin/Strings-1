#// Time Complexity : O(n) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dicti = Counter(s)
        ans = ""
        for i in order:
            if i in dicti:
                ans += dicti[i] * i
                del dicti[i]
        for k,v in dicti.items():
            ans += k * v
        
        return ans

# Approach:
# 1. Create a dictionary to store the frequency of each character in the string s.
# 2. Iterate over the string order and for each character, append it to the result string
# as many times as its frequency in the dictionary. Remove the character from the dictionary
# after appending it to the result string.
# 3. Iterate over the remaining characters in the dictionary and append them to the result string
# as many times as their frequency.
# 4. Return the result string.