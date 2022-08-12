# Time complexity: O(n)-traversing the string only once
# space complexity: O(1)- max 26 alphabets storage in hashmap
# Approach: have two pointers- slow and fast
# keep movinf fast forward until value at fast is not in hashmap
# if in hashmap, update the slow to the value of one index greater  than the value found in hashmap.
# but do not move the slow backwards because we have already omitted that case.
# update the length with maximum of current length and fast-slow+1


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = dict()
        n = len(s)
        slow = 0
        maxlen = 0
        for i in range(n):
            if s[i] in map:
                slow = max(slow, map[s[i]]+1)
            map[s[i]]= i
            maxlen = max(maxlen, (i-slow + 1))
        return maxlen
            
        