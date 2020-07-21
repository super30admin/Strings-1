#3. Longest Substring Without Repeating Characters
# Time Complexity : O(n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# intialise fast, slow to 0 index now check if ele at fast is in map if yes then we will assign the max val of curr index and ele present in map to slow and increment the fast . caluclate the max value which is dif of fast and slow and return the max after fast reaches end of string
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        fast = 0
        slow = 0
        maxv = 0
        mapp = {}
        while fast < len(s):
            if s[fast] in mapp:
                slow = max(slow,mapp[s[fast]])
            mapp[s[fast]] = fast + 1
            maxv = max(maxv,fast-slow +1)
            fast += 1
        return maxv
        