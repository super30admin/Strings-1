#Time Complexity: O(n), as each character is visited at most twice, once by the right pointer r and once by the left pointer l
#Space Complexity: O(min(n, m)), where n is the length of the string s and m is the character set size, as the charset set stores only unique characters in the window at any time
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Brute Force
        res = 0 
        for i in range(0,len(s)):
            charset = set()
            for j in range(i, len(s)):
                if(s[j] in charset):
                    break
                else:
                    charset.add(s[j])
            res = max(res, len(charset))
        return res

        #Sliding Window
        charset = set()
        res = 0
        l = 0
        for r in range(l,len(s)):
            while(s[r] in charset):
                charset.remove(s[l])
                l += 1
            charset.add(s[r])
            res = max(res, len(charset))
        return res