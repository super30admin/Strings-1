'''

Did it run on leetcode: Yes
Did you face any problem: No

Time Complexity: 0(N+MLogm)
Space Complexity: 0(N)

Algorithm:
- create hashmap with key as char of S and value as index of char in S
- by default this hashmap returns infinity
- then create a heap of characters of T with a tuple of array as (weight,char in T)
- sort the above array based on the weight

'''


from collections import defaultdict
import heapq

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        
        order=defaultdict(lambda: float("inf"))
        for index,character in enumerate(S):
            order[character] = index
        
        tList = [(order[char],char) for char in T]
        heapq.heapify(tList)
        
        
        orderedT = []
        while tList:
            orderOf,char = heapq.heappop(tList)
            orderedT.append(char)
        
        return "".join(orderedT)
        
        