# Time Complexity - O(n)
# Space - O(n) [worst case]

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start = 0
        end = 0
        count = 0
        map = {}
        while end<len(s):
            val = s[end]
            if val in map and map[val]>=start:
                start = map[val]+1
            if start>=end:
                map = {}
            map[s[end]]=end
            count = max(count,end-start+1)
            end+=1
        return count
            