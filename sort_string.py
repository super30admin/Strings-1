# // Time Complexity :O(m+n)
# // Space Complexity :O(1), 26 characters stored in hashmap max
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap={}
        # result=[]
        result=" "
        for i in range(len(s)):
            if s[i] not in hmap.keys():
                hmap[s[i]]=1
            else:
                hmap[s[i]]+=1
        for i in range(len(order)):
            if order[i] in hmap.keys():
                n=hmap[order[i]]
                # result.append(order[i]*n)
                result=result+(order[i]*n)
                del hmap[order[i]]
        for i in hmap.keys():
            n=hmap[i]
            # result.append(i*n)
            result=result+(i*n)
        return result.strip()
        
                
            
            
        