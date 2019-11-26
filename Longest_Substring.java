TC: O(n^2)
SC: O(1)

987 / 987 test cases passed.
Status: Accepted

Approach : Brute Force


class Solution:
    def lengthOfLongestSubstring(self, s):
        self.s=s
        max=0
        for j in range(len(self.s)):
            substring =""
            count=0
            for i in range(j,len(self.s)):
                substring=self.s[j:i] 
                if(substring.find(self.s[i])!=-1):
                    break
                else:
                    count=count+1
            if(count>max):
                max=count
                        
        return max
