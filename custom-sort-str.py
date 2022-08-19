"""
Runtime Complexity: O(length of string) - lets say the string length is 'n' then O(n)
Space Complexity: O(1) - we create a hashmap but then we pop elements from it. 
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if len(order)==0:
            return s
        h_map = {}
        
        for i in range(len(s)):
            char = s[i]
            if char not in h_map:
                h_map[char] = 1
            else:
                h_map[char]+=1
        
        strs = ""
        for i in range(len(order)):
            char = order[i]
            if char in h_map:
                num = h_map[char]
                str_ = "".join([char for j in range(num)])
                strs+=str_
                h_map.pop(char)
        
        if len(h_map)!=0:
            for char in h_map:
                num = h_map[char]
                str_="".join([char for j in range(num)])
                strs+=str_
        return strs
                
        