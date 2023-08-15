#Time Complexity :O(m) where m is the lenth of s
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map={}
        result=[]

        for i in range(len(s)):
            if s[i] not in map.keys():
                map[s[i]]=0
            map[s[i]]=map[s[i]]+1
        
        for seq in order:
            if seq in map.keys():
                result.append(seq*(map[seq]))
                del(map[seq])
        
        for i in map.keys():
            result.append(i*(map[i]))

        return ''.join(result)