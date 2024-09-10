# Time complexity = O(n)
# Space complexity = O(1)
# Strategy - avoid shrinking of window using hmap
# low = max(low, hmap[ch] + 1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap = dict()

        low = 0
        max_len = 0
        for i,ch in enumerate(s):
            if ch in hmap:
                # take the max for current low and current repeated character + 1 and dont move the low back if the ch already exist in the hmap
                low = max(low, hmap[ch] + 1)
            hmap[ch] = i
            max_len = max(max_len, i - low + 1)
        return max_len




# two pointer solution
# Time complexity = O(2n)
# Strategy - shrinking and expanding the window 
# Space complexity = O(1)
        # i = j = 0
        # n = len(s)
        # max_len = 0
        # hset = set()
        # while i < n and j < n: #O(n)
        #     if s[j] not in hset:
        #         hset.add(s[j])
        #     else:
        #         while(s[i]!=s[j]):
        #             hset.remove(s[i])
        #             i += 1
        #         i += 1 # escape the same character encountered
        #     j += 1
        #     max_len = max(max_len, j-i)
        # return max_len
