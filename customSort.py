"""
    Time : O(N)
    Space = O(N) -> no of unique character
    Leetcode : yes
    Explanation : Make a string using the string T, add the characters in order.
    Then add all the remaining characters from S.
"""
class Solution:
    def customSortString(self, S: str, T: str) -> str:

        count = collections.defaultdict(int)
        for i in T:
            count[i] += 1
            
        ans = []

        for c in S:
            ans.append(c * count[c])

            count[c] = 0

        for c in count:
            ans.append(c * count[c])

        return "".join(ans)