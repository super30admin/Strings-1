class Solution:
    # Time Complexity - O(logN)
    # Space Complexity - O(N) where N is len(s)
    # Use hashmap to store the last visited index of that particular character
    # Use 2 pointer start and end to indicate the substring with longest length
    def lengthOfLongestSubstring(self, s):
        if s is None or len(s) == 0:
            return 0
        maxCount = 0
        hashmap = {}
        start = 0
        end = 0
        while end < len(s):
            ch = s[end]
            if ch in hashmap:
                start = max(start, hashmap[ch])
            hashmap[ch] = end + 1
            maxCount = max(maxCount, end-start+1)
            end += 1
        return maxCount
                
        