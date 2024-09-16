#Time Complexity:O(n)
#Space complexity:O(1)
#Ran successfully on Leetcode:Yes
#Algorithm:
#1.Create a hashmap for elements in string and their idx+1, this is done while traversing the given string.
#2. If the given character was already present in the hashMap, then update slow and max length variables. 
#3. return max length.
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is  None or len(s)==0:
            return 0
        maxl=0
        hashMap={}
        slow=0
        for idx, ele in enumerate(s):
            print(idx,ele)
            if ele in hashMap:
                slow=max(slow,hashMap[ele])
                
            maxl=max(maxl,idx-slow+1)
           
            
            hashMap[ele]=idx+1
        # print(hashMap)
        return maxl
       
