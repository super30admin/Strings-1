# Time Complexity : O(n + m)
# Space Complexity : O(1) (since the map has at most 26 entries, constant-size alphabet).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First we count how many times each character appears in s using a map.
# Then we add characters from order into the result in their given order and required frequency.
# Finally, we add any leftover characters from s that weren’t in order.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_map = Counter(s)
        res = []

        for ch in order:
            if ch in freq_map:
                for i in range(freq_map[ch]):
                    res.append(ch)
                del freq_map[ch]

        if len(freq_map) > 0:
            for key in freq_map.keys():
                for i in range(freq_map[key]):
                    res.append(key)

        return "".join(res)

        