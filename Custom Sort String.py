# -*- coding: utf-8 -*-
"""
TC: O(M + N)- where M is length of T and N is the length of S
SC: O(1) we will store only max of 26 char in dictionary and O(M) there is space associated with length of string T
"""

class Solution(object):
    def customSortString(self, S, T):
        dic = {}
        # check char in dic if not =1 or increment 1
        for char in T:
            if char not in dic:
                dic[char] = 1
            else: 
                dic[char] += 1
        result = []
        
        # iterate through S and check char is in dic if present append with char * dic[char] and del that entry
        for char in S:
            if char in dic:
                result.append(char * dic[char])
                del dic[char]
        
        # iterate again and see for left over and add it in result
        for char in dic:
            result.append(char * dic[char])
        return "".join(result)       