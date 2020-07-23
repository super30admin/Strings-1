# Time Complexity : Add - O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Make freq hashmap of each charchter in T
2. Iterate thru each charachter in S, and append it the number of frequency, also keep decreasing the frequency
   as you append
3. Now all remainng charachters with frequency > 0, can be appended in any fashion
4. convert the list into String and return
'''

from collections import Counter
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        if len(S)<1 or len(T)<1:
            return
        
        freqT = Counter(T)
        
        #append the charachter based on the sequence in S, and based on the frequency
        result = []
        for i in S:
            if i in freqT and freqT[i] > 0:
                for j in range(freqT[i]):
                    result.append(i)
                    
                freqT[i] = 0
           
        #remaining charachters can now be appended just by iterating through the dict     
        for j in freqT:
            if freqT[j] > 0:
                for k in range(freqT[j]):
                    result.append(j)
                    
                freqT[j] = 0
                
        return "".join(result)