#Time Complexity : O(n) where n is the length of the input string
#Space Complexity : O(1) as the hashmap can be max of 26 letters
#Did this code successfully run on Leetcode : Yes

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        longest = 0
        start = 0
        #iterate through the string
        for end, char in enumerate(s):
            #if char is not seen already or if it seen but our start pointer has moved past it's index then update lengthOfLongestSubstring result
            if char not in seen or (char in seen and start > seen[char]):
                longest = max(longest, end-start+1)
            #if it seen already then update start to the index of the previous index of the character in the string plus 1
            else:
                start = seen[char]+1
            #add char and it's index to seen hashmap
            seen[char] = end

        return longest
