class Solution:
    """
    Approach 1: Two pointers and hashset
    1) maintain the substring candidate in the hashset
    2) have two pointers to escape the duplicated chars
    TC: O(2n)
    SC: O(n)
    """

    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        hash_set = set()
        start = 0
        max_len = 0
        end = 0

        while end < len(s):
            if s[end] in hash_set:
                hash_set.remove(s[start])
                start += 1
            else:
                hash_set.add(s[end])
                end += 1
            max_len = max(max_len, end - start)
        return max_len

    # Approach 2: Two pointers and hash map
    """
    1) if a duplicate is found, you need to escape that duplicate with a new start pointer
        a) use hashmap ot record the next index of the previous occurance if the curr index
        b) this will be your escape index
        c) update the end index and max_len at every change
    TC: O(n)
    SC: O(n)
    """

    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        hash_map = {}
        start, end, max_len = 0, 0, 0
        for end in range(len(s)):
            char = s[end]
            if char in hash_map:
                start = max(start, hash_map[char] + 1)  # becasue start cannot go backward
            hash_map[char] = end
            max_len = max(max_len, end - start + 1)
        return max_len