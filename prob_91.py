# leetcode 791
# algo : we put all the elements of T in a hash map amd keep adding it to the result string as we encounter  every string if present in S and in hash map  and finally append emaining elements in hash map not present in S and return
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        # base case  -- first step
        if not (S) or len(S) == 0 or not (T) or len(T) == 0:
            return T
        # step 2 - declare variables
        hash_map = {}
        result = ""  # here I am using a list as there is no string builder in Python, instead I could use a list and convert it to string in O(1) rather than xreating a new variable in evry go
        # step 3 - Create hash map for T
        for c in T:
            if c in hash_map:
                hash_map[c] += 1
            else:
                hash_map[c] = 1
        # step 4 : Add elements present in S and in T in that order
        print(hash_map)
        for c in S:
            if c in hash_map:
                for i in range(hash_map[c]):
                    result += c
                hash_map.pop(c)
        # t = list(hash_map.keys())
        # #print(t)
        # #print(hash_map)

        # step 5 : Add the remaining elements that is elements not present in s to return string
        while (len(hash_map.keys()) != 0):
            t = list(hash_map.keys())[0]

            for i in range(hash_map[t]):
                result += t
            del hash_map[t]
        return result
        # i did not understand why the below code did not work
        # while hash_map.keys() and t:
        #     #for i in hash_map[t]:
        #     for i in range(hash_map[t[0]]):
        #         result += str(t[0])
        #     hash_map.pop(t[0]) # this will not effect logic , its only to clear memory
        #     t.pop()
        # return result
