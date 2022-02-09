# Time Complexity : O(M)
# Space Complexity : O(1)
# running on leetcode : Yes
# Any problems faced while coding it out : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        ans=""
        hmap={}
        for i in range(len(s)):
            if s[i] not in hmap:
                hmap[s[i]]=1
            else:
                hmap[s[i]]+=1
        for j in range(len(order)):
            if order[j] in hmap:
                ans+=order[j]*hmap[order[j]]
                del hmap[order[j]]
        for i in hmap:
            ans+=i*hmap[i]
        return ans