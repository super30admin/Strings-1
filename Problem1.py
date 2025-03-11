# Problem 1 : Custom Sort String
# Time Complexity : O(m+n) where m is the length of order and n is the length of s
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # hash map to store the frequency count of character of string s
        hashmap = {}
        # loop through string s and set the hashmap with the frequency count of each character of the string
        for i in range(len(s)):
            if s[i] in hashmap:
                hashmap[s[i]] += 1
            else:
                hashmap[s[i]] = 1
        # initialize the result variable to store result
        result = ''
        # loop through order to get the order of the characters
        for i in range(len(order)):
            # check if the character of order is in hashmap
            if order[i] in hashmap:
                # if it is present then get the count of the character
                count = hashmap[order[i]]
                # add that character to the result count times
                for j in range(count):
                    result += order[i]
                # after copying the character remove the entry of the character from the hashmap
                hashmap.pop(order[i])
        # Check if there any other character in hashmap apart from order
        if hashmap:
            # if it is then get the key and count from the hashmap
            for key, count in hashmap.items():
                # add the character to the result count times
                while count > 0:
                    result += key
                    count -= 1
        return result