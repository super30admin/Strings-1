# Time complexity : O(n)
# Space complexity : O(n) to maintain queue and set

# The code ran on Leetcode

# Maintain a set to store all the elements present in this sub string. Use a queue to process one element at a time. If the incoming element is already present in the set, keep popping elements from the left of the queue until there are no duplicates.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        queue = deque(); hash_set = set()
        for i in range(len(s)):
            while queue and s[i] in hash_set:
                popped = queue.popleft()
                hash_set.remove(popped)
            queue.append(s[i])
            hash_set.add(s[i])
            res = max(res, len(hash_set))
        return res
