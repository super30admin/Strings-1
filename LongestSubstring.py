#// Time Complexity : O(n) n is lengthof string
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dicti = set()
        slow = 0
        maxi = 0
        for i,j in enumerate(s):
            if j in dicti:
                while s[slow] != j:
                    dicti.remove(s[slow])
                    slow +=1
                slow += 1
            dicti.add(j)
            maxi = max(maxi,i - slow + 1)
        return maxi

# Approach:
# 1. Initialize a set dicti to store unique characters in the current substring.
# 2. Initialize two pointers, slow and fast, to the start of the string.
# 3. Iterate over the string with the fast pointer.
# 4. If the character at the fast pointer is in dicti, it means we
# have encountered a repeated character. In this case, we need to
# move the slow pointer to the right until the repeated character is removed from dicti.
# 5. Add the character at the fast pointer to dicti and update the maximum
# substring length maxi if necessary.
# 6. Return the maximum substring length maxi.