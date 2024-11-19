"""
Brute Force: find all substrings and check if a char is repeated? O(n^2). THere are 2 iterations.

Whe there are nested loops how to remove those?
(1) Binary search, (2) two pointers, (3) hash map, (4) sliding window.

Optimal: sliding window. Use the set to store the character
TC: O(2n) slow and fast both traverse the string, SC:O(1)

For one pass, use hmap where key is the character and value is the index, so that you can directly jump to the position.
TC: O(n) slow and fast both traverse the string, SC:O(1)
"""


class Solution_one_pass:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if not s:
            return 0

        ans = float("-inf")
        sub_set = {}
        slow = 0

        for fast in range(len(s)):
            if s[fast] in sub_set: # if char in hmap, the slow pointer may or may not move
                                # it will move only when charcater is in current sliding window
                slow = max(slow, sub_set[s[fast]] + 1)

            sub_set[s[fast]] = fast # add the character to hmap with index if the char in window update the index

            le = fast - slow + 1
            ans = max(ans, le)

        return ans


class Solution_brute_force:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if not s:
            return 0

        ans = float("-inf")
        for i in range(len(s)):
            sub_str = set()  # create substring for each index
            for j in range(i, len(s)):
                if s[j] not in sub_str:
                    sub_str.add(s[j])
                else: # the character is repeated
                    break
            # this statement cannot be in else it is possible that the code never goes inside else for length " "
            ans = max(ans, len(sub_str))

        return ans


class Solution_sliding_window:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if not s:
            return 0

        ans = float("-inf")
        sub_set = set()
        slow = 0

        for fast in range(len(s)):
            if s[fast] in sub_set:
                while s[fast] != s[slow] and slow < fast:
                    print(s[slow], s[fast])
                    sub_set.remove(s[slow])
                    slow += 1
                slow += 1
            else:
                sub_set.add(s[fast])

            le = fast - slow + 1
            ans = max(ans, le)

        return ans

