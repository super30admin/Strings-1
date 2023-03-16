#Time Complexity : O(N)), N being the number of values in s. 
#Space Complexity : O(N), N being the number of values in s. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to debug an issue where I used order[i] rather than o. Had
# to create print statements in order to figure it out. 
#Your code here along with comments explaining your approach in three sentences only
'''Create a dictionary of values in s with frequency of values. Then, pop the values from keys from the order
and then place the remaining values into any order. 
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        #create dictionary of values to frequency for s.
        dictionary = {}
        for i in range(len(s)):
            if s[i] not in dictionary.keys():
                dictionary[s[i]] = 1
            else:
                dictionary[s[i]] = dictionary[s[i]]+1
        #for each value in order, pop from dictionary and add to result. 
        result = ""
        for i in range(len(order)):
            o = order[i]
            if o in dictionary.keys():
                for i in range(dictionary[o]):
                    result = result + o
                dictionary.pop(o)
        #place remaining values from dictionary into result. 
        for k in dictionary.keys():
            for i in range(dictionary[k]):
                result = result+k
        return result
