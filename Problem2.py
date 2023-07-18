#Time complexity is O(n)
#Space complexity is O(1)
#Code ran successfully on leetcode
#No issues faced while coding

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        #Initializing all the required variables
        self.hmap={}
        if(len(s)==0):
            return 0
        self.start=0
        self.maxi=0
        #We will be going through each character in the string 
        for i in range(len(s)):
            #If the character is already present in the hashmap, we will find the maximum value 
            #between the start value and the value present in the hashmap
            if(s[i] in self.hmap):
                self.start=max(self.hmap[s[i]]+1,self.start)
            #We will add or update value of s[i] in the hashmap
            self.hmap[s[i]]=i
            #We will be storing the maximum length of the longest string
            self.maxi=max(self.maxi,i-self.start+1)
        #Finally we will be returning the maximum value        
        return self.maxi
                
        
