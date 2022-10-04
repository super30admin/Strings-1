"""
Time Complexity : O(n) where n is the length of string 
                  
Space Complexity : O(1) as hashMap will contain maximum 256 characters (All the ASCII values)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Brute Force:
Create all the possible subsets and if any character repeats in any of the subset do not consider. Otherwise calculate the length and return the maximum length.

Time Complaity: O(n^3) where n is the number of characters in the string.
                n^2 is for creating a loop
                Another iteration is to check the duplicate character in a subset and calulating a string.

Space Complexity: O(n^2)

So nesting iteration problem can be solve using 1. Sliding Window 2. Two pointers 3. Hashing

We can use Sliding window approach here
1. Place the pointer slow and fast = 0
2. Create a hashMap of characters in a sting, move fast pointer and add respective character in hashMap with key as character and value as index + 1.
3. Everytime we move the fast pointer check if the character is present in hashMap.
4.If it is present, get its corresponding value from hashMap and move the slow pointer to the max(hashMap value , slow pointer's value). Maximum value because the character we are checking should be between range of current sliding window.
5. Calulate the maximum length as fast-slow + 1
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashMap = {}
        slow = 0
        maxLength = 0
        for i in range(len(s)):
            c = s[i]
            if c in hashMap:
                slow = max(hashMap[c], slow)
            hashMap[c] = i+1
            maxLength = max(maxLength, i-slow+1)
        
        return maxLength
            