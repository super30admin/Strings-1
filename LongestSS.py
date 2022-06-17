#  TC - O(n)
# OC - O(n)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        substring = ""
        string_length = len(s)
        result = 0

        for i in range(string_length):
            if s[i] not in substring:
                substring = substring + s[i]
                result = max(result, len(substring))
            else:
                pivot = substring.index(s[i])
                substring = substring[pivot+1:]
                substring = substring + s[i]

        return result
