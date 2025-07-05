"""
TC: O(N+M) where N is len(order), M=len(s)
SC: O(26) ~O(1)
Logic:
Count the occurences of each character in s
Iterate through the order and find the number of occurences of order[i] in mapper and append that many to result. Set the value as 0 afterwards in the map
Iterate through s and append the non zero valued keys to res for that many times as its keys
Convert res to string and return
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        mapper=Counter(s)
        res = []
        for i in order:
            res.append(i*mapper.get(i,0))
            mapper[i] = 0
        for i in mapper.keys():
            if mapper[i]!=0:
                res.append(i*mapper.get(i,0))
        return "".join(res)