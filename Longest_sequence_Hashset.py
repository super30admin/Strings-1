# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted
# Hashset Solution
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # define slow pointer
        slow = 0
        # set to see the characters seen so far
        seen = set()
        # to keep the max length of subsequence seen so far
        max_count = 0
        
        # keep a for loop to iterae over the string s
        for i in range(len(s)):
            ch = s[i]
            # check if the character is present in the set, if so, then we increment the slow pointer until we have reach the current character
            # also remove the characters from the set along the way
            if ch in seen:
                while s[slow] != ch:
                    seen.remove(s[slow])
                    slow += 1
                # remove the current chracter and increment the slow pointer
                seen.remove(s[slow])
                slow += 1
            # find the max count, using the i which is at current char and slow which was before
            max_count = max(max_count, i - slow + 1)
            # keep on adding characters to the set if not seen so far
            seen.add(ch)
            
        return max_count
