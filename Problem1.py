# 791. Custom Sort String

# Time Complexity: O(m+n); run on both order and str
# Space Complexity: 0(m) ; where m is the size of the str; stored in hashmap
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: Store all the characters in str in a hashmap. While traversing through order, search in hashmap and then build
# the string according to the count of the character found in str. Return the built string. 

class Solution:
    def customSortString(self, order: str, string: str) -> str:
        
        # create a hashmap with all the alphabets in the string
        result = []  
        dict_string = {}
        
        for alpha in list(string):
            
            if alpha in dict_string:
                dict_string[alpha]+=1
            else:
                dict_string[alpha] = 1
                
        for s in list(order):
            
            if s in dict_string:
                count = dict_string[s]
            
                for i in range(0, count):
                    result.append(s)
                dict_string[s] = 0
        
        for k,v in dict_string.items():
            
            if v != 0:
                count = v
                for i in range(0, count):
                    result.append(k)
        
        return "".join(result)
