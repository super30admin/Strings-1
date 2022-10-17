#Time Complexity: O(S.length + T.legnth)
#Space Complexity: O(T.length)
#Did it run on leetcode: Yes

class Solution(object):
    def customSortString(self, S, T):
        count = collections.Counter(T)
        ans = []
        for c in S:
            ans.append(c * count[c])
            count[c] = 0
        for c in count:
            ans.append(c * count[c])

        return "".join(ans)