"""
Time Complexity : O(n) + O(n-k) where n is the length of string 
                  k is the length of order strinf
                  
Space Complexity : O(1) as hashMap will contain maximum 26 letters only as string will contain the lowercase English letters only.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Prepare one hashMap, it will be frequency/numberofCharacters/count map.
2. Loop througth the order and find its per character count from hashMap. 
   Append the required charater count number of times to the result string.
   And remove those charaters from hashMap
3. Iterate to all the remaining characters in the hashMap and append to the result string
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        "Time Complexity :O(n) + O(n-k)"
        "Space Complexity : O(1)"    
        hashMap = {}
        result =''
        for i in range(len(s)):
            if s[i] in hashMap.keys():
                hashMap[s[i]] = hashMap[s[i]] + 1
            else:
                hashMap[s[i]] = 1
        
        for char in order:
            if char in hashMap.keys():
                count = hashMap[char]
                for i in range(count):
                    result = result + char
        
                hashMap.pop(char)
            
        for key, value in hashMap.items():
            for i in range(value):
                result = result + key
        
        return result