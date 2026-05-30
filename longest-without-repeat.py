# time O(n)
# space: O(1) since character map is bounded by ascii
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        l=0
        res=0
        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[r])
                # escape the repeating character
                l+=1
            charSet.add(s[r])
            res = max(res,r-l+1)

        return res


# use a map, one pass:
# time O(n)
# space: O(1) since character map is bounded by ascii
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # "pwwkew"
        #.     i
        slow = 0 # 2
        maxLen = 0 # 2
        mapChar = {} #{p=0,w=1,k=3,i=4}
        for i in range(len(s)):
            c = s[i]
            if c in mapChar:
                slow = max(slow,mapChar[c]+1)
            mapChar[c]=i
            maxLen = max(maxLen,i-slow+1)

        return maxLen