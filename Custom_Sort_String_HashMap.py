# Created by Aashish Adhikari at 6:25 PM 2/8/2021

'''
Time Complexity:
If m is the num of characters in S and n is the num of characters in T, O(m + 3n) . But  m has a maximum of 26, So O(n).

Space Complexity:
If n is the length of the string in t, O(n) for the hashmap to store n and O(n) for the list that stores the characters of t.
join() operation takes O(n) but we return its result and thus is not counted.

join() adds up the lengths of all strings to join, allocates a string big enough to hold the result, and then copies the input strings into the result.
'''

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """


        # Record all the elements of T
        hm_T= {}

        for elem in T:      # O(n)
            if elem in hm_T:
                hm_T[elem] += 1
            else:
                hm_T[elem] = 1

        sol = []



        # store all elements of S in order in the solution
        for ele in S: #O(m) ~ O(1) since 26 max charactes possible
            if ele in hm_T:

                total = hm_T[ele]

                for idx in range(0, total):
                    sol.append(ele)
                hm_T[ele] = 0


        # Append the remaining elements of T
        for remaining in hm_T:      # O(n)
            if hm_T[remaining] > 0:
                total = hm_T[remaining]
                for idx in range(0, total):
                    sol.append(remaining)

        return "".join(sol) # O(n)


