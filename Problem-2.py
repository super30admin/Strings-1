# T.C = O(n) S.C = O(n)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_ = 0
        slow = 0
        hash_map = {}
        for i in range(len(s)):
            c = s[i]
            if c in hash_map:
                slow = max(slow,hash_map[c]+1)
            hash_map[c] = i
            max_ = max(max_,i-slow+1)
        
        return max_