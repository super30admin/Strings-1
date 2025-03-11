# Problem 2 : Longest Substring Without Repeating Characters
# Time Complexity : 
'''
1st Approach Sliding window - O(n) where n is the length of the string
2nd Approach Jumping- O(n) where n is the length of the string
'''
# Space Complexity : 
'''
1st Approach Sliding window - O(n) where n is the length of the string
2nd Approach Jumping- O(n) where n is the length of the string
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# Sliding Window approach 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # initialize the result variable
        result = 0
        # check edge case when s in None or length is zero
        if s == None or len(s) == 0:
            return result
        # defining the hashSet to store unique characters from the string
        hashSet = set()
        # get the length of string s and initialize the start pointer
        length = len(s)
        start = 0 
        # loop through string
        for end in range(length):
            # check if the character at end position is in hash set
            if s[end] in hashSet:
                # if it is present then move the slow pointer untill the s[start] is not equal to s[end]. Also remove s[start] from hash set
                while s[start] != s[end]:
                    hashSet.remove(s[start])
                    start += 1
                # move on pointer ahead of duplicate element
                start += 1
            else:
                # else add the element to hashSet
                hashSet.add(s[end])
            # store maximum values between result and length(end-start+1)
            result = max(result, end-start+1)
        return result

 
# Jumping approach 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # check edge case when s in None or length is zero
        if s == None or len(s) == 0:
            return 0
        # initialize the pointers and result variable
        start = 0 
        end = 0
        result = 0
        # intialize the dict/map which will store character and its index in string
        dict = {}
        # loop till length of the string
        while end < len(s):
            # check if s[end] is in dictionary
            if s[end] in dict:
                # if it is then update the start pointer to maximum value of start or value of s[end] key in map 
                # here we don't want to move start point backwards
                start = max(start, dict[s[end]])
            # update the value of s[end] key in map with current index + 1 since index start from 0
            dict[s[end]] = end + 1 
            # store maximum values between result and length(end-start+1)
            result = max(result, end-start+1)
            # increment the end pointer
            end += 1
        return result