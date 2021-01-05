class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        #1) follow order in S
        #2) arrange chars in T
        #traverse in S and place elements from T with their respective occurences
        #check if anymore extra occurences left in T that are not in S, simply add them too
        #O(t+s)
        #O(26)
        mpT={}
        ans=""
        for i in T:
            mpT[i]=mpT.get(i,0)+1
        for i in S:
            if i in mpT:
                ans+=(i*mpT[i])
                del mpT[i]
        for i in mpT:
                ans+=(i*mpT[i])
        return (ans)
                