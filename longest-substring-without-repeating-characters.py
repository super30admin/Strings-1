
# TC - o(n)
# SC = o(mp = 128 )




class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        mp={}
        left  = result = 0
        
        for Right in range(len(s)):
            if s[Right] in mp:
                left = max(left,mp[s[Right]])
            result = max(result,Right - left+1)
            mp[s[Right]] = Right+1
        
        return result
