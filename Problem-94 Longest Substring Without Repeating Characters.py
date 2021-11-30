# 3. Longest Substring Without Repeating Characters
# https://leetcode.com/problems/longest-substring-without-repeating-characters/

# Logic: Use two pointers, slow and fast. letter at fast should be checked if it is present 
# in the hashmap, if not we add the index in the hashmap. If it is already present, it means 
# that in the current substring we have encountered this letter before. We chec its index in 
# the hashmap and then update the slow pointer to the next of this index and update the index 
# for the letter in the hashmap. Length of the substring will be equal to fast-slow+1 and at 
# every step we store the max. 

# Time Complexiety: O(n)
# Space Complexiety: O(1) [worst case O(26) if all the characters are put in the hashmap]

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = dict()
        max_count = 0
        
        slow = 0
        fast = 0
        
        while fast < len(s):
            if s[fast] not in hashmap:
                hashmap[s[fast]] = fast
            else:
                index = hashmap[s[fast]]
                if slow <= index < fast:
                    slow = hashmap[s[fast]] + 1
                hashmap[s[fast]] = fast
            
            max_count = max(max_count, fast-slow+1)
            fast += 1
        return max_count