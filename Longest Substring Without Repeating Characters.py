class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        first ,second ,maxLen ,currLen = 0,0,0,0
        uniqueChar = set()
        while(first < len(s)):
            if s[first] not in uniqueChar:
                uniqueChar.add(s[first])
                currLen += 1
                first += 1
                
            else:
                while(s[second] != s[first]):
                    uniqueChar.remove(s[second])
                    second += 1
                    currLen -= 1
                second += 1
                first += 1
            maxLen = max(currLen, maxLen)
            print(uniqueChar)
        return maxLen
                
