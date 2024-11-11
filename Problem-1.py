# T.C = O(n) S.C = O(n))
class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """

        hmap = {}
        result = []

        for c in s:
            if c in hmap:
                hmap[c] += 1
            else:
                hmap[c] = 1

        for c in order:
            if(c in hmap):
                freq = hmap[c]
                for i in range(freq):
                    result.append(c)
                del hmap[c]

        for c in hmap.keys():
            freq = hmap[c]
            for i in range(freq):
                result.append(c)

        return ''.join(result)
        