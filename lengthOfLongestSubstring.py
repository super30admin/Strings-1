# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        result = 1
        index1 = 0
        index2 = 1
        while index2 < len(s):
            hashmap = {}

            for i in range(index1, index2 + 1):
                hashmap[s[i]] = hashmap.get(s[i], 0) + 1

            if len(hashmap) == ((index2 + 1) - index1):
                result = max(result, (index2 - index1 + 1))
                index2+=1

            else:
                index1 +=1
            if index1 == index2:
                index2 +=1
        return result
