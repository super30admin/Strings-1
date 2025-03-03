class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
#sliding window

        char_dict = {}
        start = 0
        max_length = 0

        for end in range(len(s)):
            if s[end] in char_dict and char_dict[s[end]] >=start:
                start = char_dict[s[end]]+1

            max_length = max(max_length,end-start+1)

            char_dict[s[end]] = end

        return max_length



#time n  n is the length of the string 
# space min(n,m) m is the size of character set
