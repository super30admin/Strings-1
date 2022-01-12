# Leetcode execution : YES
# Time complexity:O(max (len(order), len(s)))
# Space Complexity: O(1) since only 26 characters for lowe letters alphabet
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        mapp={}
#         loop through the string given to count the number of occurances of the chacater and store in mapp dictionary

        for x in s:
            if x in mapp:
                mapp[x]+=1
            else:
                mapp[x]=1
        result=""
        # now we are looping through the orde rstring and if the character is not in map comtinue
        # if it is present then gte the count and thta many times add it to the result array
        # if the count becomes 0 then remove from the dictionay 
        
        for x in order:
            if x not in mapp:
                continue
            count=mapp[x]
            for i in range(count):
                result+=x
                mapp[x]-=1
            if mapp[x]==0:
                mapp.pop(x)
            
        # last we will be loping through the dictionay mapp to add remaining characters to the result based on its count     
        for x in mapp:
            for i in range(mapp[x]):
                result+=x
        return result