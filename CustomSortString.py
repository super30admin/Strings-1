'''
TC: O(n) - n is the length of characters in the s since order has fixed 
            26 characters
SC: O(1) - only 26 characters to store in dictionary
'''
import collections

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        countdict = collections.defaultdict(int)
        for ch in s:
            countdict[ch]+=1
        res = ""
        for ch in order:
            res += countdict[ch]*ch
            countdict[ch]=0
        for ch,count in countdict.items():
            res += countdict[ch]*ch
        return res
s = Solution()
print(s.customSortString("cba", "abcd"))
print(s.customSortString("cba", "abcdeabdhsvndk"))
print(s.customSortString("zba", "sdjfhbkjsknc"))