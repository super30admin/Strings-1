# Time Complexity: O(N)
# Space Complexity: O(N)

# Here we use a slow and fast pointer
# Here, we maintain a hashset and if we encounter a repeated element
# we move slow until the repeated element is not encountered
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Using HashSet
        hashset = set()
        slow = 0
        maxs = 0

        for fast in range(len(s)):
            if s[fast] in hashset:
                while s[slow]!=s[fast]:
                    hashset.remove(s[slow])
                    slow+=1
                slow+=1
            else:
                hashset.add(s[fast])
                maxs = max(fast-slow+1,maxs)
        return maxs

        # Using HashMap
        # hashmap = dict()
        # slow = 0
        # maxs = 0
        # for fast in range(len(s)):
        #     if s[fast] in hashmap:
        #         slow = max(slow,hashmap[s[fast]]+1)
        #     hashmap[s[fast]] = fast
        #     maxs = max(fast-slow+1,maxs)
        #         # slow = hashmap[s[fast]] + 1
        #         # hashmap[s[fast]] = fast
        #         # slow = fast
        # return maxs