'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 3. Longest Substring Without Repeating Characters

# Given a string s, find the length of the longest substring without repeating characters.



#-----------------
# Time Complexity: 
#-----------------
# O(N) - Need to process N characters in input string
#------------------
# Space Complexity: 
#------------------
# O(1): Max size of hashmap = 26 characters and their index - constant

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        slow = 0
        fast = 0
        max_len = 0
        hash_map = {}
        
        while fast < len(s):
            c = s[fast]
            if c in hash_map:
                slow = max(slow, hash_map[c])
            max_len = max(max_len, fast-slow + 1)
            hash_map[c] = fast + 1
            fast += 1
        
        return max_len