'''
1. Maintain a hashMap of each character and its index + 1 to begin at next index when a duplicate is found.
2. Traverse the string, if a duplicate is found, update the start index to the max of start and the index of the duplicate character + 1.
3. Calculate length of the substring as i - start + 1 and update the Max.

TC: O(n) where n is the length of the string.
SC: O(1) as there are only lower case letters.
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
          return 0
          
        hashMap = dict()
        start = 0
        Max = 0
        for i in range(len(s)):
          c = s[i]
          if c in hashMap:
            start = max(start, hashMap[c])
          Max = max(Max, i - start + 1)
          hashMap[c] = i + 1
        return Max 

