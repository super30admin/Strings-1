#Time complexity - O(n)
#Space complexity - O(n)
#Works on leetcode - yes
#Approach - We use dictionary to store the location of the chars we have seen before . At each iteration ,we check have we 
#seen it before, if yes, we get the position and set start to the used[s[i]] +1 if start is <= this position. Else we set the max length 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        used = {}
        start, maxlen = 0,0
        for i in range(len(s)):
            if s[i] in used and start <= used[s[i]]:
                start = used[s[i]]+1
            else:
                maxlen = max(maxlen, i-start+1)
            used[s[i]] = i
        return maxlen