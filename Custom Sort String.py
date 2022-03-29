# Time Complexity: O(n^2)
# Space complexity : O(n)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        s_hashmap = {}
        ans = ""
        for i in range(len(order)):
                hashmap[order[i]] = i
        for j in s:
            if j in s_hashmap:
                s_hashmap[j]+=1
            else:
                s_hashmap[j] = 1
        for z in hashmap:
            if z in s_hashmap:
                for kk in range(s_hashmap[z]):
                        ans+=z
                del s_hashmap[z]

        for d in s_hashmap:
            for k in range(s_hashmap[d]):
                ans+=d
        return ans


