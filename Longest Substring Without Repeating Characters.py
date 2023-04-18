class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Hash Set Approach
        # Time O(2n)
        # Space O(k)
        # hashset = set()
        # maxlen = 0
        # currlen = 0
        # p1 = 0
        # for p2 in range(len(s)):
        #     if s[p2] not in hashset:
        #         hashset.add(s[p2])
        #         currlen += 1
        #     else:

        #         while s[p1] != s[p2]:
        #             hashset.remove(s[p1])
        #             p1 += 1
        #             currlen -= 1
        #         p1 += 1
        #         # currlen -= 1
        #     maxlen = max(maxlen, currlen)
        #     # print(currlen)
        #     # print(p1,p2)
        # return maxlen

        # Hash Map approach
        # Time O(n)
        # Space O(k)
        hmap = {}
        maxlen = 0
        slow = 0
        for i in range(len(s)):
            ch = s[i]
            if ch in hmap:
                if hmap[ch] >= slow:
                    slow = hmap[ch] + 1

            hmap[ch] = i
            maxlen = max(maxlen, i - slow + 1)

        # print(hmap)
        return maxlen




