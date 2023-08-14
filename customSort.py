#TC - O(len(S)+len(order))
#SC - O(len(S))
class Solution:
    def customSortString(self, order: str, S: str) -> str:
        count = collections.Counter(S)
        ans = []

        for c in order:
            ans.append(c * count[c])
            count[c] = 0

        for c in count:
            ans.append(c * count[c])

        return "".join(ans)
