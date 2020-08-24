#Time complexity - O(max(s,t)) where s is length of string S and t is length of string T
#Space complexity - O(t)
#Works on leetcode - yes
#Approach - First we save the frequency of letters of T and then iterate through S. If any letter from S is in the dictionary, we add it with 
#its frequency to result and delete that letter from dictionary. If dictionary is not empty yet, we add the rest of letters to the result
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        count = collections.Counter(T)
        res = []
        for i in S:
            if i in count:
                res.extend([i]*count[i])
                del count[i]
        for k,v in count.items():
            res.extend(k*v)
        return ''.join(res)