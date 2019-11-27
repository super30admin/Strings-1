# time complexity:o(n)
# space complexity:O(1)
# leetcode: accepted
# explaiation: there are two pointers slow and fast and a maximum variable that will be returned as a result.
# you will be creating a default dictinoary and not the normal dictionary because,when to check if a string not already there,
# it will give me a key error if i use normal map. If i use deafult doct, it will return 0.

# you iterate throught the string and keep putting the characters as keys and values will be their next index.
# so when the fast pointer encounters the char again, slow knows where to jump. at the same time,
# you will keep on finding the distance between the slow and the fast pointer.(which is max)

# once the fast pointer reaches the end, you will return max


from collections import defaultdict


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or s is None:
            return 0
        slow = 0
        fast = 0
        max1 = 0
        d = defaultdict(int)
        l = len(s)
        while (fast < l):
            if d[s[fast]] > 0:
                # when the character is already present, slow should move to the next index
                slow = max(slow, d[s[fast]])
            d[s[fast]] = fast + 1
            max1 = max(max1, fast - slow + 1)
            fast += 1
        return max1


