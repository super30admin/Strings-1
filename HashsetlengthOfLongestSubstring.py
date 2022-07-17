#Time complexity : O(n) where n is length of string
#Space complexity : O(1) as the maximum character in hashset will be 26 so space is constant
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/ZOPk3E8t_CA
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s=="" and len(s)==0:
            return 0
        if s==" ":
            return 1
        #defining the hashset for keeping track of character and the index where the particular character is located
        hashset =set()
        #defining the slow and fast pointer
        #slow pointer will only move it till we skip the repeated character
        #fast pointer will traverse the string
        fast = 1
        slow = 0
        #we are assigning maximum with 1 becasue we are starting the fast from index 1 of the string
        maximum = 1
        hashset.add(s[0])
        #iterating the while loop till we encounter 
        while fast<len(s):
            c = s[fast]
            if c in hashset:
                while s[slow]!=c:
                    #we are removing the elements from the set once the repeated is encountered 
                    hashset.remove(s[slow])
                    slow +=1
                #we will escape the repeated character
                slow+=1
            #if character c is not in set
            hashset.add(c)
            fast +=1
            #for fast- slow the difference will always be in difference of 1
            maximum = max(maximum, fast-slow)
        return maximum
