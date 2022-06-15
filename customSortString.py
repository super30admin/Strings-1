'''
Time Complexity: 0(n) asymptotically
Space Complexity: 0(n) [dict with all unique keys]
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        # initialize a dictionary
        dict = {}
        
        # iterate (s) and fill-up the dictionary
        for ele in s:
            if ele not in dict:
                dict[ele] = 1
            
            else:
                dict[ele] = dict[ele]+1
        
        # iterate order to create a string
        outString = ""
        for ele in order:
            if ele in dict:
                outString = outString + ele*dict[ele]
                del dict[ele]
        
        # append the remaining keys
        for key in dict:
            outString = outString + key*dict[key]
        
        # print the out string
        # print(f"Outstring is {outString}")
        return outString