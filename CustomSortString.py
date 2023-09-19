#Time Complexity : O(n) where n is the length of string s
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We use dictionary to store the frequency of each characters in the string s. Then we iterate through the order string.
# If the character is present in the map, we take the corresponding count and add the characters for the number of count in the result
# and then remove that character from the dictionary. In the end we add all the characters left in the dictionary for the number
# of corresponding counts. We join the characters in the result list and return the same.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        mapp = {}
        for i in s:
            if i in mapp:
                mapp[i] += 1
            else:
                mapp[i] = 1
        result = []
        for i in order:
            if i in mapp:
                cnt = mapp[i]
                for j in range(cnt):
                    result.append(i)
                del mapp[i]

        for i in mapp:
            cnt = mapp[i]
            for j in range(cnt):
                result.append(i) 
        
        return ''.join(result) 