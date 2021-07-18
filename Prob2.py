class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        #time complexity: O(n)
        # space complexity: O(1)
        chmap = {}
        maxstr = 0
        slow = 0
        for idx,ch in enumerate(s):
            if ch in chmap:
                slow = max(slow,chmap[ch])
            maxstr = max(maxstr,idx-slow+1)
            chmap[ch] = idx+1
        return maxstr
