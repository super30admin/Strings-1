# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We store 2 poitners, one end and one start. The end pointer keeps moving at each step. The difference between these pointers is the current length of the substring
#At each step, we store the occuring character and it's location in a hashmap. If a character occurs again, we update the start to the character's location + 1 or the current start itself, whichever is higher

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        longest_distance = 0
        curr_map = {}
        for end,char in enumerate(s) :
            if char not in curr_map:
                curr_map[char] = end
            else :
                start = max(curr_map[char] + 1,start)
                curr_map[char] = end
            longest_distance = max(end-start+1, longest_distance)
        return longest_distance
