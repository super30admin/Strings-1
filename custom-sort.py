# Time Complexity: O(len(S)+len(T))
# Space Complexity: O(26) - Constant
# Approach: Store the count of every character in T in a map or array(26). Iterate over S and for every char in S that is in the map, append the character*count to result array and delete the entry from the map. Iterate over the remaining characters in the map and append character*count to the result.

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        t_count = collections.Counter(T)

        res = []
        for c in S:
            if c in t_count:
                res.append(c*t_count[c])
                del t_count[c]

        for c in t_count:
            res.append(c*t_count[c])

        return "".join(res)
