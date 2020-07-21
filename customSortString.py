#791. Custom Sort String
# Time Complexity : O(T) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
#iterate through the char in input string and store its count in a dict. Now ieterate through S and check if its in mapp if yes add the char in S no of times as that of count. Cont untill we cover all ele in S. Then we will append all the items of map which are left out and return the result
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        mapp = {}
        res = ''
        for i in range(len(T)):
            if T[i] in mapp:
                mapp[T[i]] += 1
            else:
                mapp[T[i]] = 1
        for i in range(len(S)):
            if S[i] in mapp:
                count = mapp[S[i]]
                while count:
                    res += S[i]
                    count -= 1
                mapp.pop(S[i])
        for i,c in mapp.items():
            while c:
                res += i
                c -= 1
            
        return res

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        counter = collections.Counter(T)
        res = []
        
        for count in S:
            if count in counter:
                res.append( count * counter[count])
                counter[count] = 0
        for count in counter:
            res.append(count * counter[count])
            counter[count] = 0
        return "".join(res)