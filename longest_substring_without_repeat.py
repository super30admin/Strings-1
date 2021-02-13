# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use 2 pointers left and right. I increment right and I enter index of element in a map. If element for right is already present then I move the 
# left pointer to the previous occurence of the element if its greateer than left. Everytime I move right I update max length.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mapping = defaultdict(lambda: 0)
        left = 0
        max_length = 0
        max_range = (0,0)
        for i, letter in enumerate(s): #i = 2, letter = m
            if letter in mapping: 
                left = max(left, mapping[letter] + 1) # left = 2
                
            mapping[letter] = i
            length = i - left + 1 # length = 2
            if length > max_length:
                max_length = length #
                max_range = (left, i)
        print(max_range)   
        return max_length
