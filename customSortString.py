# Time Complexity : O(M + N) 
# Space Complexity : O(1) <- letters in hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        """
        put T in a hashmap
        iterate on S. 
        """
        hm = defaultdict()
        res = [] 
        
        for i in T:
            if i not in hm:
                hm[i] = 1
            else:
                hm[i] += 1 
                
        for i in range(len(S)):
            if S[i] in hm:
                freq = hm[S[i]]
                res.append(S[i]*freq)
                
                del hm[S[i]]
                
        for key, val in hm.items():
            res.append(key * val)
        
        return ''.join(res)