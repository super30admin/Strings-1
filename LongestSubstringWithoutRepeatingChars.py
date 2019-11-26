#Accepted on leetcode
#Time complexity - O(N)) where N is len of s
#Space omplexity - O(N) use of hashmap


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        #Edge case
        if s == None or len(s) == 0:
            return 0
        #Logic
        dic = {}
        max_length = start = 0
        for i, c in enumerate(s):
            if c in dic and start <= dic[c]:
                start = dic[c] + 1
            else:
                max_length = max(max_length, i - start + 1)
            dic[c] = i
        return max_length