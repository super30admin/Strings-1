# Time Complexity : O(n) [n=length of s]
# Space Complexity : O(1) [HashMap has only a fixed number of ascii char, so constant space]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not sure if the exact number of iteration in v1 solution would be 2n

# Problem approach
# 1. Use a Map to keep track of the unique charatcters as well as the index of the occurence of the charatcter
# 2. Use two pointers start and end to traverse the string
#   2.1 Increment end one of the following is satisfied
#       2.1.1 if the char is not in map
#       2.1.2 index of the char in map is less than start(the char is not present in string under consideration)
#   2.2 Else update start with 1 + index of the last occurennce of character
class Solution_v1:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:return 0
        start, end = 0,0
        max_count = 1
        n = len(s)
        char_map = {}
        while start < n and end < n:
            # char_map[s[end]] < start -> the char is not present in string under consideration
            if s[end] not in char_map or char_map[s[end]] < start:
                char_map[s[end]] = end
                end+=1
                max_count = max(max_count, end-start)
            else:
                start = char_map[s[end]]+1
        return max_count


class Solution_v2:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:return 0
        start, end = 0,0
        max_count = 1
        char_map = dict()
        while end < len(s):
            if s[end] in char_map:
                start = max(start, char_map[s[end]])
            char_map[s[end]] = end+1
            max_count = max(max_count, end-start+1)
            end+=1
        return max_count