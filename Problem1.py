'''

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We go thru the elements in s and add them to a hashmap alongwith their frequency of occurence as the value. Then we iterate over order string
and add them to a result string according to the order with the frequency of occurrence

'''

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        s_dict = defaultdict(int)
        res = ""

        for c in s:
            if c in s_dict:
                s_dict[c] += 1
            else:
                s_dict[c] = 1

        for c in order:
            if c in s_dict:
                res = "".join([res,c*s_dict[c]])
                s_dict.pop(c)

        for c in s_dict.keys():
            res = "".join([res,c*s_dict[c]])

        return res
