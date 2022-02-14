"""
TC: O(n)
sc:-O(1)- since there will always be 26 keys present in the hashmap
https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        maxlen = 0
        slow = 0
        hashmap = {}  ##O(1) space time constat
        start = 0
        end = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                ##move the slow pointer index and jump to the index after we saw its repeatiion
                slow = max(slow, hashmap[s[i]])

            if i - slow + 1 > maxlen:
                maxlen = i - slow + 1
                start = slow
                end = start + maxlen
                substring = s[start:end]

            # maxlen=max(maxlen, i-slow+1)
            hashmap[s[i]] = i + 1
        print(substring)
        return maxlen

        # if len(s)==0:
        #     return 0
        # hashset=set()
        # longestlength=1
        # for i in range(len(s)):
        #     hashset.add(s[i])
        #     length=1
        #     for j in range(i+1, len(s)):
        #         if s[j] in hashset:
        #             break
        #         hashset.add(s[j])
        #         substring=s[i:j+1]
        #         # print(substring)
        #         length=len(substring)
        #         longestlength=max(longestlength, length)
        #     hashset.clear()
        # return longestlength


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        maxlen = 0
        slow = 0
        hashmap = {}  ##O(1) space time constat
        for i in range(len(s)):
            if s[i] in hashmap:
                ##move the slow pointer index and jump to the index after we saw its repeatiion
                slow = max(slow, hashmap[s[i]])
            maxlen = max(maxlen, i - slow + 1)
            hashmap[s[i]] = i + 1
        return maxlen

        # if len(s)==0:
        #     return 0
        # hashset=set()
        # longestlength=1
        # for i in range(len(s)):
        #     hashset.add(s[i])
        #     length=1
        #     for j in range(i+1, len(s)):
        #         if s[j] in hashset:
        #             break
        #         hashset.add(s[j])
        #         substring=s[i:j+1]
        #         # print(substring)
        #         length=len(substring)
        #         longestlength=max(longestlength, length)
        #     hashset.clear()
        # return longestlength


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = {}
        slow = 0
        maximum = 0
        start = 0
        end = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                ###slow ko assign kiya max of slow
                slow = max(slow, hashmap[s[i]])

            if i - slow + 1 > maximum:
                maximum = i - slow + 1
                start = slow
                end = i

            # maximum=max(maximum, i-slow+1)

            hashmap[s[i]] = i + 1

           ### Input: s = "pwwkew"
            ### p1 w-2 slow=0, max=0, start=0, end=0

        print(s[start:end + 1])
        return maximum


