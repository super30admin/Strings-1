#Time complexity : O(n) where n is length of string
#Space complexity : O(1) as the maximum character in hashmap will be 26 so space is constant
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/ZOPk3E8t_CA
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #defining the hashmap for keeping track of character and the index where the particular character is located
        map ={}
        #defining the slow and fast pointer
        #slow pointer will only move once the character is repeated
        #fast pointer will traverse the string
        fast = 0
        slow = 0
        #definig global maximum for storing the maximum length of the string
        maximum = 0
        #iterating on the string
        for i in range(len(s)):
            #storing the current character
            c = s[fast]
            if s[fast] in map:
                #we are taking maximum because slow won't move back
                slow = max(slow, map[c])
            #changing each time the value of maximum where from the 2nd parameter we will consider the length after repeating parameter
            maximum = max(maximum, i - slow +1)
            map[c] = fast +1 
            fast+=1
        return maximum
            
