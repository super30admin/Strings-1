# Solution

# // Time Complexity : O(N) when we use Dictionary and save indexs with sliding window
#                      O(2N) when we use SET with sliding window
# // Space Complexity : O(1) since at max there can be just 26 characters
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Dictionary with sliding window: This is almost similar to the SET solution. Only difference is, we keep the index of each
# character in the dicitonary. So when we get to the repeated character, we can just move the low pointer one ahead of the index
# saved. One thing is, we will only keep updating the indexs in dictionary, without removing the elements, so we might find
# elements that are still in dicitonary, whoose index is less than low. Those should be ignored.
# SET with sliding window: We can use two pointers for sliding window. Keep adding the elements into a set and keep incrementing
# the "high". The moment we find an element which is already there in set, that tells us that the previous length is the current
# longest length. Now we can remove that from dictionary and move the low pointer till it crosses the first occurence of 
# the repeated element. Now we can repeat the process and keep taking the count. The maximum count out of all the iterations will
# give us the max length with unique keys

import math
def lengthOfLongestSubstring(s):
    low = 0
    high = 0
    n = len(s)
    charDict = {}
    result = -math.inf
    count = 0
    while high<n and low<n:
        if s[high] in charDict and charDict[s[high]] >= low:
            result = max(result,count)
            low = charDict[s[high]] + 1
            count = high - low + 1
            charDict[s[high]] = high
            high += 1
        else:
            charDict[s[high]] = high
            high += 1
            count += 1
    
    return max(result,count)

    # low = 0
    # high = 0
    # n = len(s)
    # charSet = set()
    # count = 0
    # result = -math.inf
    # while high<n and low<n:
    #     if s[high] in charSet:
    #         result = max(result,count)
    #         while s[low] != s[high]:
    #             charSet.remove(s[low])
    #             low += 1
    #             count -= 1
            
    #         charSet.remove(s[low])
    #         low += 1
    #         count -= 1
    #     else:
    #         charSet.add(s[high])
    #         count += 1
    #         high += 1
    
    # return max(result,count)

if __name__ == "__main__":
    s = "abcabcbb"
    print(lengthOfLongestSubstring(s))