# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Two Pointers. Intialize left pointer to 0 and HashMap
# Iterate over the string and check if the character at index i is in HashMap if not add the character to HashMap and its index as value
# Else we increment left to the max of left or index of the character that is in HashMap + 1
# Then update the current index for that character in HashMap
# Get the maxlength from left to i + 1
# Return maxlength

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxlength = 0
        stringset = set()
        if not s:
            return maxlength
        left = 0
        for i in range(len(s)):
            if s[i] not in stringset:
              stringset.add(s[i])
            else:
                while s[left] != s[i]:
                    stringset.remove(s[left])
                    left += 1
            if s[left] == s[i] and left < i:
                left += 1
            maxlength = max(maxlength, len(stringset))
        return maxlength
#Time - O(n)
#Sapce - O(n)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxlength = 0
        if not s:
            return maxlength
        stringdict = {}
        left = 0
        for i in range(len(s)):
            if s[i] not in stringdict:
                stringdict[s[i]] = i
            else:
                left = max(left, stringdict[s[i]] + 1)
                stringdict[s[i]] = i
            maxlength = max(maxlength, i-left+1)
        return maxlength
#Time - O(n)
#Sapce - O(n)
        