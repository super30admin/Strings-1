#Time Complexity :O(T) T is size of string 
#Space Complexity :o(S) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        if(T==None or len(T)==0):
            return ""
        hmap={}
        
        for i in T:
            if(i in hmap):
                hmap[i]+=1
            else:
                hmap[i]=1
         
        strt=""
        for i in S:
            if(i in hmap):
                count=hmap[i]
                while(count):
                    strt+=i
                    count-=1
                del hmap[i]
        
        for i in hmap:
            count=hmap[i]
            while(count):
                strt+=i
                count-=1
            
        
        return strt