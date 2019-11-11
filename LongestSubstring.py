#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 11 11:39:33 2019

@author: tanvirkaur
"""

# Brute force = we will generate all possible substrings and try to find the substring of max length without repeating characters . Time complexity = O(N^3), Space complexity = 
# Sliding window cocept : slide the start pointer whenever you find a repeating character . slide the start to one position ahead of the repeatiing character
# we have to maintain two pointers strating and ebding from the same position
# problem faced : after if we should not use else because no matter what we hav eto update the value in the dictionary
# Sliding window solution:
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        dict1 = {}
        start = 0
        end = 0
        maxlen = 0
        while end < len(s):
            if s[end] in dict1:
                start = max(start, dict1[s[end]])
            dict1[s[end]] = end+1
            maxlen = max(maxlen, end-start+1)
            end += 1
        return maxlen