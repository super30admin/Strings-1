'''
Solution: 
    - Maintain a HashMap, storing {ch - index+1}, index at where they appear
    - Left, right pointer. if right pointer comes across a previously seen char
      update left to max(left,index where this character previously occured.)
      We do max, because we want to move left pointer always forward. 
    - at each iteration, calculate length of substring s[left:right]. Update 
      max_length accordingly.
Time Complexity: O(N), N = length of s, iterating over all characters
Space Complexity: O(N), HashMap. 
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        right = 0
        char_index_map = {} # {ch - index}
        longest_length = 0

        while right<len(s):
            if s[right] not in char_index_map:
                char_index_map[s[right]] = right+1
            else:
                left = max(left,char_index_map[s[right]])
                char_index_map[s[right]] = right+1
            
            longest_length = max(longest_length, right-left+1)
            right+=1
        

        return longest_length