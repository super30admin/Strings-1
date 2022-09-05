# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # default values for slow, max_count and an emoty Hashmap
        slow = 0
        seen = {}
        max_count = 0
        
        # traversing over the string
        for i in range(len(s)):
            # check if the character is present in the Hashmap
            ch = s[i]
            if ch in seen:
                # if present then increment the slow pointer to the max of slow and the char seen right now
                slow = max(slow, seen[ch])
            # update the max_count to max of max_count so far and current index - slow + 1
            max_count = max(max_count, i - slow + 1)
            # update the new index of the char to curr index + 1
            seen[ch] = i + 1
        return max_count
