class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        stringMap={}
        start=0
        maxi=0
        for i in range(len(s)):
            if s[i] in stringMap:
                start=max(start,stringMap.get(s[i]))
            maxi=max(maxi,i-start+1)
            stringMap[s[i]]=i+1
        return maxi