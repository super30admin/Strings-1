'''
Using Hashmap
Time: O(n)
Space: O(1), as there will be max 26
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        res = 0
        slow = 0
        temp = dict()
        for i in range(len(s)):
            c = s[i]
            if c in temp:
                slow = max(slow, temp[c])
            temp[c] = i+1
            res = max(res, i-slow+1)
        return res


'''
Using Hashset
Takes bit more time than Hashmap
Time: O(2n) --> O(n)
Space: O(1)
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        res = 0
        hs = set()
        slow = 0
        for i in range(len(s)):
            c = s[i]
            if c in hs:
                while s[slow] != c:
                    hs.remove(s[slow])
                    slow += 1
                slow += 1
            hs.add(c)
            res = max(res, i-slow+1)
        return res
        