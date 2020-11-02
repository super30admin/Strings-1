#Time Complexity: O(S+T), S,T-> Lengths of strings
#Space Complexity: O(T)
#Run on Leetcode: Yes
#Any Issues: No

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