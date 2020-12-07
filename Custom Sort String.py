# Time Complexity:- O(S+T)
# Space Complexity:- O(T)
# Approach:- Maintain a frequency map of T, iterate over S, if char of s is in T append the number of time this charachter has occured in T into the res array.
# This way we maintain the order in which charachters have occured in S and the resultant is a string which is equal to the length of T.
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        t=collections.Counter(T)
        res=[]
        for i in S:
            # charachters in S which are in t but we are iterating over S so the resultant will be in the order in which they appeared in s
            if i in t:
                res.append(i*t[i])
                del t[i]
        # charachters in T which are not in s
        for i in t:
            res.append(i*t[i])
        return "".join(res)