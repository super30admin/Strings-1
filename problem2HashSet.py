"""
Time Complexity : O(2n) where n is the length of string 
                  
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
1. Take two pointers slow = 0 and fast = 1
2. Iterate the fast pointer till we get the duplicate character.
3. Once the repeated element is found move the slow pointer until you find repeated element. And set the slow = repeated element + 1
4. Every time fast is iterated add the element to set 
5. Everytime slow pointer is move, remove the element from set
6. Record the length as fast - slow +1

"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 1:
            return 1
        if len(s) == 0:
            return 0
        hashSet = set()
        slow = 0
        fast = 1
        hashSet.add(s[slow])
        maxLength = 0
        
        while(fast < len(s)):
            if s[fast] in hashSet:
                c = s[fast]
                while(s[slow] != c):
                    hashSet.remove(s[slow])
                    slow += 1
                slow += 1
            hashSet.add(s[fast])
            maxLength = max(maxLength, fast-slow+1)
            fast += 1
            
        return maxLength