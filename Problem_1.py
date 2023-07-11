"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Counting the number of occurences of all characters in the source string in the hashmap
adding the characters in order string, if they are present in the source string, until their count
in the hashmap becomes 0, then moving on the next character in the order and creating result string just by using
characters from order string, then adding characters from source string to result string, which are not
present in the order string and returning the result

"""

# Custom sort string

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        hmap={}
        for i in range(len(s)):
            if s[i] in hmap:
                hmap[s[i]]+=1
            else:
                hmap[s[i]]=1
        result=""
        for i in range(len(order)):
            c=order[i]
            if c in hmap:
                count=hmap[c]
                while count:
                    result+=c
                    count-=1
                hmap[c]=0
        
        for k in hmap.keys():
            if hmap[k]!=0:
                count=hmap[k]
                while count:
                    result+=k
                    count-=1
                hmap[k]=0


                

        
        return result