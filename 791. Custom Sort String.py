##791. Custom Sort String##############################################################################################
// Time Complexity : m+n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We created hash map for s string and stored the string and its count, now we go through the order and check if the element is present in hash map if it is present than we will add it to list as the count and once it is added to list we will remove the entry from the hash map. Once this process is complete we will be left with the elements which are not in order and we can add them also in list and at last return the list by performing the join

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        l1=[]
        dict1={}
        for i in s:
            if i not in dict1:
                dict1[i]=0
            dict1[i]+=1
        for i in order:
            if i in dict1:
                cnt=dict1[i]
                for j in range(cnt):
                    l1.append(i)
                dict1.pop(i)
        for i in dict1:
            for j in range(dict1[i]):
                l1.append(i)
        return ''.join(l1)
