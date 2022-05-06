// Time Complexity : O(len(order) + len(string))
// Space Complexity : O(1) i.e. dictionary o(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
     

                m={}
                #Count occurences of alphabets in string
                for i in s:
                    try:
                        m[i]=m[i]+1
                    except:
                        m[i]=1

                f=''
				# append the alphabets to result string
				# based on order string
                for j in order:
                    try:
                        while m[j]>0:
                            f=f+j
                            m[j]=m[j]-1
                    except:
                        pass

                for j in m:
                    try:
                        while m[j]>0:
                            f=f+j
                            m[j]=m[j]-1
                    except:
                        pass
                return f

        
                
            
                
                
                
        
        