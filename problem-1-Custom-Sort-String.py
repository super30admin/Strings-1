"""
Problem:
https://leetcode.com/problems/custom-sort-string/

Approach: 

1. create frequency map of String T
2. for each character in S, find if that character is in the map, if yes take the count of that char and add those many characters
3. in the end take all the characters from the map and append to the result

"""

# Time Complexity : O(n) where n is the Length of string T
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        output =""
        map1 = {}
        for c in T:
            if c in map1:
                map1[c]+=1
            else:
                map1[c]=1
        for c in S:
            if c in map1:
                count = map1[c]
                for i in range(count):
                    output+=c
                del map1[c]
        for c,count in map1.items():
                for i in range(count):
                    output+=c
                
        return output
                    
        