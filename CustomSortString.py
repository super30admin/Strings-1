# Problem1 Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = dict()
        for i in range(len(s)):
            if s[i] in hashMap:
                hashMap[s[i]] += 1
            else:
                hashMap[s[i]] = 1
        result = ''
        for i in order:
            if i in hashMap.keys():
                result = result + (i * hashMap[i])
                del hashMap[i]
        for i in hashMap.keys():
            result = result + (i * hashMap[i])
        return result     
    
# Time complexity O(n + m)
# Space complexity O(m)
# n is length of given string order
# m is length of given string s