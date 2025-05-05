class Solution:
    def customSortString(self, order: str, s: str) -> str:
        """
        Approach:
        1. Count the frequency of each character in string `s` using a Counter.
        2. Iterate over characters in `order`, and for each character that exists in `s`, add it to the result the number of times it appears.
        3. Append the remaining characters (those not in `order`) to the result in any order.

        Time Complexity: O(n + m), where n = len(order), m = len(s)
        Space Complexity: O(m), for the Counter used to store frequencies of characters in `s`
        """

        s_count = collections.Counter(s)
        res = []

        for char in order:
            if char in s_count:
                res.extend([char] * s_count[char])
                del s_count[char]

        for char, count in s_count.items():
            res.extend([char] * count)

        return "".join(res)
