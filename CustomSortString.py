#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 11 11:41:10 2019

@author: tanvirkaur
"""

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        dict1 = {}
        result = ""
        for char in T:
            dict1[char] = dict1.get(char, 0) + 1
            
        for char in S:
            if char in dict1:
                result += char* dict1[char]
                del dict1[char]
        
        for k , v in dict1.items():
            result += k *v
        
        return result