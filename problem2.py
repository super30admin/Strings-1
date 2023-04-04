#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#find the length of the longest substring without repeating characters in a given string, using a sliding window approach. 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans=-1
        temp=0
        seen={}
        start=0
        length=0
        flag=False
        if(s==""):
            return temp
        for i in range(len(s)):
            if(s[i] in seen):
                flag=True
                I=seen[s[i]]
                length=i-1-start+1
                if(length>ans):
                    ans=length
                j=start
                while(j<=I):
                    del(seen[s[j]])
                    j=j+1
                seen[s[i]]=i
                start=I+1
            else:
                seen[s[i]]=i
        
        if(flag==False):
            return len(s)
        #print(start)
        if(len(s)-start > ans):
            ans=len(s)-start
            #print(start)
    
        return ans
            
