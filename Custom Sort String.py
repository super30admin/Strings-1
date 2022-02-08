# Time Complexity :
# TC: O(N+M) --> N is number of char in s, M is Number of char in order

# Space Complexity :
# SC: O(1) --> O(26)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# I used hashmap to solve this problem. The comments in program are step by step description

class Solution:
    
    # Using a Hashmap
    # TC: O(N+M) --> N is number of char in s, M is Number of char in order
    # SC: O(1) --> O(26)
    
    def customSortString(self, order: str, s: str) -> str:
        result = ''
        hashMap = dict()
        
        # Iterating Through the string s and storing all chars with their frequancy in hashmap(Frequancy Map).
        for char in s:
            if hashMap.get(char, None):
                hashMap[char] += 1
            else:
                hashMap[char] = 1
                
        # Iterating Through the string order.
        # Appending each char of order present in frequancy map to result.
        # This preserves the order of order dtring in result string.
        for char in order:
            charFreq = hashMap.get(char, 0)
            
            for i in range(charFreq):
                result += char
                
            # Removing Order char after appending it to result.
            if (charFreq):
                hashMap.pop(char)
                
        # Appending remaining characters of string s to result.
        for key, value in hashMap.items():
            for i in range(value):
                result += key
                
        return result