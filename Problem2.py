
## Problem2 

#Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)


#-----------------------------------------------#

# Set Solution

# Approach:
# Traverse through the string s. If char not in set, add it. Else, move slow pointer till char at slow == c. 
# Delete char at slow from the set. Increment slow pointer by 1 in the end to go ahead of repeated char
# calculate max_len at each iteration- max_len = max(max_len, c-slow+1). Return max_len

# Time Complexity: O(2n) = O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        repeat = set()
        max_len = 0
        slow = 0


        for c in range(len(s)):
            if s[c] not in repeat:
                repeat.add(s[c])
            else:
                while s[slow] != s[c]:
                    repeat.remove(s[slow])
                    slow += 1
                slow += 1
            max_len = max(max_len, c-slow+1)

        return max_len
    

#--------------------------------------------------------------------------------#

# Hashmap Solution

# Approach:
# Traverse through the string s. If char not in hmap, add char as key and index as value. 
# Else, move slow pointer to previously encountered index of char+1. If it is less than current slow pointer, don't update
# slow = max(slow, hmap[s[i]]+1). Update index in hmap. calculate max_len at each iteration- max_len = max(max_len, c-slow+1). Return max_len

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = {}
        max_len = 0
        slow = 0

        for i in range(len(s)):
            if s[i] in hmap:
                slow = max(slow, hmap[s[i]]+1)
                hmap[s[i]] = i
            else:
                hmap[s[i]] = i
            
            max_len = max(max_len,i-slow+1)
        
        return max_len