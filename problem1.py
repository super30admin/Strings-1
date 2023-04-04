#time complexity: O(m+n) m=len(s), s=len(order)
#space complexity: O(m)
#ran on leetcode: yes
#create a dictionary to count the frequency of each character in string 's', sort the characters based on order and update the result string with the sorted characters and then append the remaining characters from 's' not present in 'order'.

class Solution:
    def customSortString(self, order: str, s: str) -> str:

        S=dict()
        for i in s:
            if(i in S):
                S[i]+=1
            else:
                S[i]=1
        ans=''
        i=0
        while(i<len(order)):
            curr=order[i]
            if(curr not in s):
                i+=1
            else:
                ans+=curr
                S[curr]-=1
                if(S[curr]==0):
                    i+=1
        for j in s:
            if(j not in order):
                ans+=j
        
        return ans
