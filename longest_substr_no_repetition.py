# O(N) TIME and O(MIN(N,a)) space where N is len of s and a is len of alpabets

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        lastseen = {}
        longest_range = [0,0]
        currentidx = 0
        startidx = 0
        while currentidx < len(s) and startidx < len(s):
            char = s[currentidx]
            if char in lastseen:
                startidx = max(startidx,lastseen[char]+1)
            longest_range = self.compareRanges(longest_range,[startidx,currentidx])
            lastseen[char] = currentidx
            currentidx += 1
        return longest_range[1] -  longest_range[0] + 1
    

    def compareRanges(self,range1,range2):
        return range1 if range1[1] - range1[0] > range2[1] - range2[0] else range2