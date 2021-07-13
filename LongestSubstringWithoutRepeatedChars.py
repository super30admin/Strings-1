class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """using hashmap and 2 pointers
        Time complexity-O(n)
        Space complexity-O(1)"""
        # hashmap={}
        # slow=0
        # maxlen=0
        # for i in range(len(s)):
        #     if s[i] in hashmap:   
        #         slow=max(slow, hashmap[s[i]])
        #     hashmap[s[i]]=i+1
        #     maxlen=max(maxlen, i-slow+1)
        # return maxlen
        
        """Solution using 2 pointers and hashset
        Time complexity-O(2n) as we are iterating twice over array in worst case
        Space complexity-O(1)"""
        if not s:
            return 0
        hashset=set()
        maxcount=0
        slow=0
        fast=slow+1
        hashset.add(s[slow])
        while fast<len(s):
            if s[fast] in hashset:
                for i in range(slow, fast+1):
                    if s[i]==s[fast]:
                        slow=i+1
                        # hashset=set()
                        # hashset.add(s[slow])
                        break
                    else:
                        hashset.remove(s[i])
                    print(hashset,"....")
            hashset.add(s[fast])
            print(hashset)
            maxcount=max(maxcount, fast-slow+1)
            fast+=1
        if maxcount==0:
            return 1
        return maxcount
                
                
        
                
                
            
            
            
            
        
        """BruteForce approach
        Time complexity-O(n*n)
        Space complexity-O(1)"""
        # if len(s)==1:
        #     return 1
        # elif not s:
        #     return 0
        # maxcount=0
        # maxstr=""
        # for i in range(len(s)):
        #     for j in range(i+1, len(s)):
        #         if s[j] not in s[i:j]:
        #             temp=maxcount
        #             maxcount=max((j-i+1),maxcount)
        #             if maxcount!=temp:
        #                 maxstr=s[i:j+1]
        #         else:
        #             break
        # if maxcount==0:
        #     maxstr=s[0]
        #     return 1
        # return maxcount
                    
        