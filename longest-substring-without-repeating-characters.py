from collections import Counter
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        map = dict()
        maxx = 0
        slow = 0
        
        for i in range(len(s)):
            c = s[i]
            if map.has_key(c):
                slow = max(slow, map[c])
            map[c] = i+1
            maxx = max(maxx, i-slow+1)
        return maxx 
        # unq = dict()
        # max_len = 0
        # i = 0
        # maxxer = 0
        # while i < len(s):
        #     if not unq.has_key(s[i]):
        #         max_len += 1
        #         unq[s[i]] = i
        #     else:
        #         j = unq[s[i]]
        #         for key, val in unq.items():
        #             if val <= j:
        #                 max_len -= 1
        #                 del unq[key]
        #         max_len += 1
        #         unq[s[i]] = i
        #     maxxer = max(max_len, maxxer)
        #     i += 1
        # return(maxxer)