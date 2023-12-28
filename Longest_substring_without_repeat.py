# TC: O(N)
# SC: O(1)


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dict1={}
        left=0
        res=0

        for i in range(0,len(s)):
            if s[i] not in dict1:
                dict1[s[i]]=i
            else:
                if left<=dict1[s[i]]:
                    left=dict1[s[i]]+1
                dict1[s[i]]=i
            
            res=max(res,i-left+1)


        return res
        
        
        # HashSet Solution
        
        # set1=set()
        # left=0
        # res=0
        # for i in range(0,len(s)):
        #     if s[i] not in set1:
        #         set1.add(s[i])
        #     else:
        #         while s[left]!=s[i]:
        #             set1.remove(s[left])
        #             left+=1
        #         left+=1
        #     res=max(res,i-left+1)

        # print(set1)

        # return res


        #Brute Force

        # OPT=[0 for i in range(0,len(s))]
        # li=list(s)
        # if len(s)==0:
        #     return 0
        # OPT[0]=1
        # for i in range(1,len(s)):
        #     k=0
        #     liTemp=[]
        #     for j in range(i,-1,-1):
        #         if li[j] not in liTemp:
        #             liTemp.append(li[j])
        #         else:
        #             k=j
        #             break
        #         # print(j)
        #         # print(liTemp)
            
        #     OPT[i]=len(liTemp)

        # # print(OPT)
        # return max(OPT)