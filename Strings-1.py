# Strings-1

## Problem 1 Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dicti = Counter(s)
        ans = ""
        for i in order:
            if i in dicti:
                ans += dicti[i] * i
                del dicti[i]
        for k,v in dicti.items():
            ans += k * v

        return ans
# TC = O(n), SC = O(1) 

## Problem 2 Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dicti = set()
        slow = 0
        maxi = 0
        for i,j in enumerate(s):
            if j in dicti:
                while s[slow] != j:
                    dicti.remove(s[slow])
                    slow +=1
                slow += 1
            dicti.add(j)
            maxi = max(maxi,i - slow + 1)
        return maxi
# TC = O(n), SC = O(1) 