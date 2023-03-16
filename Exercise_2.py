#Time Complexity : O(N)), N being the number of values in s. 
#Space Complexity : O(N), N being the number of values in s. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to debug an issue for a long time. Ended up looking at the solution 
#and before replacing start = index+1 with start = max(start, index+1)
#Your code here along with comments explaining your approach in three sentences only
'''Create a dictionary of values to index while parsing through each character. If character is in dictionary and 
therefore repeating, then update the maximum length. 
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #base case and initialize values. 
        if len(s)<=1:
            return len(s)
        dictionary = {}
        max_sub = 0
        start = 0
        #parse through characters. 
        for i in range(len(s)):
            c=s[i]
            #if not in dictionary, add to dictionary
            if c not in dictionary.keys():
                dictionary[c]=i
                if max_sub<i-start+1:
                    max_sub=i-start+1
            else:
                # if in dictionary, calculate start and current maximum length
                index = dictionary[c]
                start = max(start, index+1)
                dictionary[c]=i
                if max_sub<i-start+1:
                    max_sub=i-start+1
        return max_sub