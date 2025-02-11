#-------------------------Time = O(2n) Sliding window Approach, Space=O(26)-------------------------------------------
#-----------------------
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:

#         hashset = set() # To store unique elements in the window
#         slow = 0 # Start with slow pointer
#         max_len = 0
#         for i in range(len(s)): # i is fast pointer
#             if s[i] in hashset: # If already present in the hashset
#                 while(s[slow] != s[i]): # Move the slow pointer until we escape it
#                     hashset.remove(s[slow]) # Also remove the elements from the hashset
#                     slow += 1
#                 slow += 1 # If slow is already at same character as i just move slow by 1 to escape it
#             # If not in hashset add that element
#             else: 
#                 hashset.add(s[i])
#             # Everytime store the max len
#             max_len = max(max_len, i - slow + 1)
#         return max_len
    
#---------------By Storing Index in the hashMap, Time = O(n), Space = O(26)-----------------
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashMap = dict()
        slow = 0
        max_len = 0
        for i in range(len(s)):
            if s[i] in hashMap and slow <= hashMap[s[i]]: # only update slow if the currrent char is in the window
                slow = hashMap[s[i]] + 1
            
            hashMap[s[i]] = i

            max_len = max(max_len, i - slow + 1)
        return max_len