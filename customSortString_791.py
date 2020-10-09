# // Time Complexity : O(S+T)
# // Space Complexity : O(T)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
# Brute Force: For s in each character, check in t: if found-> remove from t and add to output array: taking O(n*m*m) time.
# Better approach would be to store number of characeters count using hashmap

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        hmap ={}
        
        #store all chars of T in the hashmap with their count
        for i in T:
            if i not in hmap:
                hmap[i] = 1
            else:
                hmap[i] +=1
                
        #start iterating through S and if a char in S is present in hmap:
        #add it to the output string and resuce the cnt
        # if count is zero-> remove the char from hmap
        
        output = '' 
        for j in S:
            if j in hmap:
                cnt = hmap[j]
                while cnt > 0:
                    output += j
                    cnt -= 1
                del hmap[j]
        
        #add remaining chars that were not found in the S string in any order
        for k in hmap:
            cnt = hmap[k]
            while cnt>0:
                output += k
                cnt -= 1
                
        return output
        
                
        