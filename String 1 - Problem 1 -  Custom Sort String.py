"""
FAANMG Problem #94 {Medium} 

791. Custom Sort String


Time Complexity O(n)
Space Complexity:  O(1) - 26 Char
        
Did this code successfully run on Leetcode : Yes


Approach --
1. Create a freq map
2. Create the resultant string based on the count as per the given order
3. Append the remaining string

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        # maintain a hashmap for frequency count
        seen = {}

        # add the frequency of characters from string s to the hashmap
        for ch in s:
            seen[ch] = 1 + seen.get(ch,0)


        # result is an empty string
        res = ''

        # traversing over the order string, check for each character, fetch the freq of that from the map
        # then add that many characters to the result preserving the order
        for ch in order:
            if ch in seen:
                count = seen[ch]
                
                for i in range(count):
                    res += ch
                    
                # delete/pop the keys which are added to the resultant string
                del seen[ch]

        # after going over the order, if there are any keys left in the map, traverse over them in any order, and add it to the res
        for key,count in seen.items():
            
            for i in range(count):
                    res += key

        return res
        