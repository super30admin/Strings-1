# Time Complexity : O(n+m)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        #store T elements in map
        res = {}
        for i in T:
            if i not in res:
                res[i] = 1
            else:
                res[i] += 1
        
        output = ''
        #check whether present in S if yes then add it to op one by one
        for j in S:
            if j in res:
                cnt = res[j]
                while cnt > 0:
                    output += j
                    cnt -= 1
                del res[j]
        
        #add remaining value
        for k in res:
            cnt = res[k]
            while cnt > 0:
                output += k
                cnt -= 1
            
        
        return output
                