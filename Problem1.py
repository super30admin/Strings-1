'''
Time Complexity: O(m + n) where m and n is length of order and string respectively
Space Complaxity: O(n) where s is length of the string
Run on Leetcode: YES
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hMap = {}
        for i in range(len(s)):
            if s[i] not in hMap:
                hMap[s[i]] = 0
            hMap[s[i]] += 1
        result = ''
        for ch in order:
            if ch in hMap:
                for _ in range(hMap[ch]):
                    result += ch
                del hMap[ch]
        for key in hMap.keys():
            for _ in range(hMap[key]):
                    result += key
        return result