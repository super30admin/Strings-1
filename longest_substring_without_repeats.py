class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # #sliding window as set, if jth element is unique, keep on computing new window size and extend window
        # #if jth element is not unique, then remove ith element from window and shrink window from left to reacha a point where window actually contains unique elements only
        # #O(n)
        # i=0
        # j=0
        # ans=0
        # n=len(s)
        # window_set=set()
        # while i<n and j<n:
        #     if s[j] not in window_set:
        #         ans=max(ans,j-i+1)
        #         window_set.add(s[j])
        #         j+=1
        #     else:
        #         window_set.remove(s[i])
        #         i+=1
        # return ans
        
        #O(n)
        #O(26)
        #1) sliding window for substring
        #2) check repeats in map
        slow=0
        mp={}
        maxl=0
        res=[]
        for fast in range(len(s)):
            c=s[fast]
            if c in mp:
                #if repeat char found, move slow wrto max of either prev slow position or map position
                slow=max(slow,mp[c])
            #next char to be accessed is fast+1
            mp[c]=fast+1
            
            #  find actual substring answer
            # cur=fast-slow+1
            # if cur>maxl:
            #     res=[s[slow:fast+1]]
            # elif cur==maxl:
            #     res.append(s[slow:fast+1])
            maxl=max(maxl,fast-slow+1)
            #print(res)
        return maxl
        
            
                
            