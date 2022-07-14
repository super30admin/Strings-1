class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Best Optimized Sliding window -  slow and fast pointer & hashmap TC-O(n) and SC-O(1)
        length = 0
        slow = 0
        Hash_map = {}
        for fast in range(len(s)):
            if s[fast] in Hash_map:
                slow = max(slow, Hash_map[s[fast]])
            length = max(length, fast - slow + 1)
            Hash_map[s[fast]] = fast + 1
        return length

    '''
        # Sliding window -  slow and fast pointer with hashset
        # TC - O(2n) = O(n),  SC - O(1)
        slow = 0
        length = 0
        hash_set = set()
        for fast in range(len(s)):
            if s[fast] in hash_set:
                while s[fast] in hash_set:
                    hash_set.remove(s[slow])
                    slow += 1

            hash_set.add(s[fast])
            length = max(length,fast-slow+1)

        return length
    '''

