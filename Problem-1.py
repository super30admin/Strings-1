from collections import defaultdict


class Solution:
    """
    Approach: counter
    1) create a counter of the given string
    2) iterate through order and get all the chars from the input string including duplicates
        a) counter can be used to do this
        b) reset the char value to 0 - meaning this char has been added to result
    3) add the remining chars from input string
        a) again use counter for this

    TC: O(n + m) |  n = len(s); m = len(order)
    SC: O(n) can also be said as O(1) since only 26 chars will be added to counter
    """

    def customSortString(self, order: str, s: str) -> str:
        result = []
        s_counter = defaultdict(int)
        for char in s:
            s_counter[char] += 1

        for char in order:
            if char in s_counter:
                result.append(char * s_counter[char])
                s_counter[char] = 0

        for char, count in s_counter.items():
            if count != 0:
                result.append(char * count)

        return "".join(result)