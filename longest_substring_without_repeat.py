# Time Complexity: O(n) where n is the length of the string s
# Space Complexity: O(1) since the hashmap will have atmost 26 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We find the longest substring without repeating characters by using a hashmap to store the index of each character within our 
substring as we itereate through s. When iterating through s, if we see that the character is already is in the hashmap, we 
move the first index of our substring to the index of that character in the hashmap and in this way maintaining uniqueness.
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        
        hashmap = dict()
        first_index = 0
        longest_substr = 0
        current_substr = 0

        for index in range(len(s)):
            if s[index] in hashmap:
                if hashmap[s[index]] == first_index:
                    hashmap[s[index]] = index
                    first_index += 1
                else:
                    first_index = hashmap[s[index]] + 1
                    hashmap = {s[i]:i for i in range(first_index, index + 1)}
                    current_substr = index + 1 - first_index

            else:
                hashmap[s[index]] = index
                current_substr += 1
                if current_substr > longest_substr:
                    longest_substr = current_substr


        return longest_substr