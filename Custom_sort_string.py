Brute Force:
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
i traverse thorugh each character in S and then i see if it is present in T ot not.If yes continue else delete it from the string S.we also need to check that if character is present in T is in S then we find where it is present and insert the character at that particular location.

# Time Complexity --> o(mn) m=len(S) and n=len(T)
# space complexity --> o(1)
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        S=list(S)
        i=0
        while i<len(S):
            if S[i] in T:
                T=T.replace(S[i],'',1)
            else:
                S[i]=''
            i=i+1
        for i in T:
            if i in S:
                 S.insert(S.index(i),i)
            else:
                S.append(i)
        return ''.join(S)

optimised solution:
# Time complexity --> o(m+n)
# space complexity --> o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we store the frequency of the string T in dictionary.TO maintain the custom order we then traverse thorugh the string S and if the element present in dictionary is encountered then we create a tempstring with that frequency and delete that character from the dictionary.In the end we concatenate the tempstring with the remaining string frequency values.
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        out=''
        d=dict()
        for i in T:
            if i not in d:
                d[i]=1
            else:
                d[i]=d[i]+1
        for i in S:
            if i in d:
                out=out+(i*d[i])
                del d[i]
        for key,value in d.items():
            out=out+(key*value)
        return(out)
        
                
        