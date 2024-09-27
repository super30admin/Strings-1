# leetcode:accepted
# time complexity: O(N)
# space complexity:O(1)
# explaination: go through the whole text and make a hashmap
# of all te letters with the count. then traverse throught the s,
# snd if the ltter is in the hasmp, add the letter so many times aas the value into the string,
# and delete it. After adding, if there are any characters remaining, appen them to the string

class Solution:
    def customSortString(self, S: str, T: str) -> str:

        dict1 = dict()
        res = ""
        for char in T:
            if char not in dict1.keys():
                dict1[char] = 1
            else:
                dict1[char] += 1

        for char in S:
            if char in dict1.keys():
                for i in range(dict1[char]):
                    res = res + (char)
                del dict1[char]

        for k in dict1.keys():
            for i in range(dict1[k]):
                res = res + k

        return res