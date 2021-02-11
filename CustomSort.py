'''
    Time Complexity:
        O(s + t) (where s and t are the lengths of the given strings)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Create a HashMap of {char:count} of T.
        Traverse through S:
            -> get the char and it's count from the generated HashMap,
                and add the char count times to the final StringBuilder.
            -> Delete this char from the HashMap.
        Traverse through the rest of the elements in the HashMap,
            and add them to the final StringBuilder in any order.
'''

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        hm = {}

        for char in T:
            if char not in hm:
                hm[char] = 0
            hm[char] += 1

        final_string = []

        for char in S:
            if char not in hm:
                continue

            final_string.extend([char] * hm[char])
            del hm[char]

        for char, count in hm.items():
            final_string.extend([char] * count)

        return ''.join(final_string)
