'''
    Time Complexity:
        O(n) (where n = length of the given string)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Sliding Window.
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        uniq_sub_str = set()
        low = 0
        high = 0
        max_len = 0

        while high < len(s):
            if s[high] not in uniq_sub_str:
                uniq_sub_str.add(s[high])
                max_len = max(max_len, len(uniq_sub_str))
                high += 1
            else:
                uniq_sub_str.remove(s[low])
                low += 1

        return max_len
