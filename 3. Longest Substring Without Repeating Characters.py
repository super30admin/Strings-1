# Time Complexity: O(N)
# Space Complexity : O(1) as only 26 chars can be in dict
class Solution:
    def lengthOfLongestSubstring(self, s):
        map = {} # Creating a dict to store chars and its index
        slow = 0
        max_length = 0 # Length of substring
        
        for i in range(len(s)):
            c = s[i]
            if c in map: # If c is already in map, choose the index which is greater and put slow pointer there. As we dont want to take the window back.
                slow = max(slow, map[c] + 1)
            map[c] = i # If not make the new entry
            max_length = max(max_length, i - slow + 1) # Calculate the length of string each time
        
        return max_length