# Problem1:Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
# Time Complexity: O(n + m), where n = len(s), m = len(order)
# Space Complexity: O(1),map holds at most 26 entries (lowercase English letters)
# Approach:
# Count how many times each character appears in s using a map.
# Walk through order left to right and for each character present in the map, append it that many times to the result, then remove it from the map (marks it as placed).
# Any characters left in the map never appeared in order, so append them at the end in any order.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map = {}                      # for character and frequency count in s

        for char in s:                # count occurrences of every char in s
            if char in map:
                map[char] += 1        # already seen, increase count
            else:
                map[char] = 1         # first time seeing it, start at 1

        string_builder = []           # list used to build result in O(1) appends

        for char in order:                  # walk order left to right, this defines final sequence
            if char in map:                 # only place chars that actually exist in s
                count = map[char]           # how many copies to place
                for k in range(count):
                    string_builder.append(char)  # place all copies together
                del map[char]                    # mark as placed, so it's not added again below

        for char in map:                     # whatever remains was not in order, no rank constraint
            count = map[char]
            for k in range(count):
                string_builder.append(char)      # dump leftovers at the end

        return ''.join(string_builder)   # join list into final string, O(n)
