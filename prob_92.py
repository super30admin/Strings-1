#leetcode - 3
# time - O(n)
#space -  O(1) #as there are onlh 26 letters
class Solution:
    def lengthOfLongestSubstring(self, s):
        #edge case
        if s==None: 
            return 0
        #1st step is initialise variables
        map = {}
        slow=0
        fast=0
        longest_str=0

        while fast < len(s): #loop tillfast reaches end of string
            if s[fast] in map: #case when key exists in the dictionary, repitiotn
                slow = max(map[s[fast]], slow)
            map[s[fast]] = fast+1 #increase fast pointer any case,  save its index
            longest_str = max(longest_str,fast+1-slow) #calculating fast evry time and if greater then apprending it 
            fast += 1
        return longest_str