#Time complexity is O(m) where m is the length of the s
#Space complexity is O(1)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        #initializing all the required variables
        self.hmap={}
        self.final_st=""
        #Iterating through each character in string s and adding teir frequencies in hashmap
        for i in s:
            if(i not in self.hmap):
                self.hmap[str(i)]=0
            self.hmap[i]+=1
        #We will be going through each character in the order stirng
        for j in range(len(order)):
            k=order[j]
            #If k is there in hashmap, we will add that to the final string x times
            #where x is the frequence of that character in the give n string
            if(k in self.hmap):
                x=self.hmap[k]
                self.final_st+=k*x
                #Once added, we delete that entry from the hashmap
                del self.hmap[k]
        #After the order, we will add all the remaining characters to the final result string
        for k,v in self.hmap.items():
            self.final_st+=k*v
        return self.final_st
        
