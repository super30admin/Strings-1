class Solution(object):
    # tc : O(nlogn) + O(m) -> O(nlogn) where n is len of s, m is the len of the order
    # sc : O(n), order_ranking saves 26 which is constant space , but s_arr where we sort the chars and save it is the extra space of n
    def customSortString(self, order, s):
        # the letters in order have the be the priority from left to right, left chracter begin high priority over the right characters and so on
        # have a list from 0-26[lower case characters] and lets think each index is for each letter, lets store the indexes of the letters in the orderstring
        # then we will have one more list where we convert the s with the above custom comparator 
        # dry run example : in order c has rank 0, b has rank 1 so in s than a , c has more priority so c is stored at the begingin of the list and the rest of elemenst which are not in order will be added as the order in the s itself

        order_ranking = [len(order)]*26 # startign with high value so the other elements which are not in order will have lesser priority
        for i in range(len(order)): # tc : O(m)
            order_ranking[ord(order[i])-ord('a')] = i # save the index 

        s_arr = [char for char in s] # sc : O(n)

        # lets sort s_arr with custom comparator
        s_arr.sort(key = lambda char: order_ranking[ord(char)-ord('a')]) # tc : O(nlogn)

        # join the chars to get the string
        output = ""
        
        return output.join(s_arr)

