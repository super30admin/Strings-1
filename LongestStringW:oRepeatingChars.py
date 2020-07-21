-------------------------------- Longest substring without repeating characters ---------------------------------------------
# Time Complexity : O(S)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I had a dict and 2 pointers which start from 0. I will iterate through high and if my high element is not in dict, I will append to
dict with its index+1. If element is present in dict then I will check max of my low pointer and dict of the high as well.
and in every iteration i will check the max length of my string. 

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        d = {}
        low = 0
        high = 0
        m = 0
        st = list(s)
        while low<=high and high <len(st):
            if st[high] in d:
                low = max(low, d[st[high]])
               
            d[st[high]] = high+1
            m = max(m, high-low+1)
            high +=1
        return m
        
-------------------------------- Longest substring without repeating characters ---------------------------------------------
# Time Complexity : O(2S) Iterating using high and low pointers.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I will use a set, I will use 2 pointers and I will append the high pointer elements into the set if not present, else I will 
# I will remove one element of low from the set until my element of low equals ele of high and i will take the string from the next element of that index.
# for each iteration i will check the maximum number of chars in a string.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        se = set()
        low = 0
        high  = 0
        m = 0
        st = list(s)
        while low<=high and high<len(st):
            if st[high] in se:
                while st[low] != st[high]:
                    se.remove(st[low])
                    low +=1
                se.remove(st[low])
                low = low+1
            
            se.add(st[high])
            high +=1
            m = max(m, len(se))
        return m