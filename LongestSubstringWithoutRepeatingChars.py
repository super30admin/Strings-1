 # Time Complexity : O(N)
# Space Complexity : O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) < 2:
            return len(s)
        # slow and fast pointers
        i,j = 0,0
        maxi = 0
        prev = {}
        prev[s[i]] = 0
        while j < len(s):
            # if the char at fast pointer is in prev
            if s[j] in prev:
                i = max(i,prev[s[j]])
            
            # maximum of previous and new substring
            maxi = max(maxi,j - i + 1)
            prev[s[j]]  = j + 1
            j += 1

        return maxi 