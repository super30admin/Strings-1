# TC O(len(order) + len(s))
# SC O(len(s))
class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        charmap = defaultdict()
        nonorder = ""
        result = ""

        for char in s:
            if char in order:
                if char not in charmap:
                    charmap[char] = 0
                charmap[char] += 1

            else:
                nonorder = nonorder + char

        for char in order:
            if char in charmap:
                cnt = charmap[char]

                for i in range(cnt):
                    result = result + char

        result = result + nonorder
        return result
