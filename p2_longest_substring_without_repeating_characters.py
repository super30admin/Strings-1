"""
Hash Map Solution:
    - Loop the string 
    - Put element as key in dict and index as key 
    - If element is in the dict and element is in range between slow and fast:
        - MOve slow pointer to element + 1
    - get the max value
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        map = dict()
        res = 0
        for i in range(len(s)):
            if s[i] in map:
                slow = max(slow, map[s[i]]+ 1)
            map[s[i]] = i
            res = max(res, i - slow + 1)
        return res            

"""
Hash Set Solution:
    - Two pointer approach
    - move fast pointer and put element in the set
    - if you see the element already in the set 
    - move slow pointer until you reach the repeat character 
    - Return the max 
"""

# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         slow = 0
#         fast = 0
#         longest = 0
#         longest_substr = set()
#         for i in range(len(s)):
#             if s[i] in longest_substr:
#                 while s[slow] != s[i]:
#                     longest_substr.remove(s[slow])
#                     slow += 1
#                 longest_substr.remove(s[slow])                                    
#                 slow += 1
#             longest_substr.add(s[i])
#             longest = max(longest, i - slow + 1)
#         return longest
