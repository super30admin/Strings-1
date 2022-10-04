# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        #Counting the occurances of every character
        mydir=collections.Counter(s)
        mystr=[]
        
        #Iterating through the order 
        for i in order:
            #If the character is in the dict then 
            #Add it to the sting as many times as it occurs
            if i in mydir:
                mystr.append(i*mydir[i])
                
                #delete the character
                del mydir[i]
        
        #Add the remeaning characters to the stirng
        for char,count in mydir.items():
            mystr.append(char*count)
        
        #Convert the list to string and return it
        return "".join(mystr)