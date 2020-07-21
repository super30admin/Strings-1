# done on July 19 2020

class Solution:
    def customSortString(self, S: str, T: str) -> str:

        # Method 1 :
        # Time complexity : len(S) = m ; len(T) = n ; O(m+n) actuall, but O(n) makes more sense
        # O(n) to create dict ; O(m) to iterate through S whose len is m, but O(m) is constant as letters are unique in S
        # Hence it is O(m) [ just len of T ]
        # Space complexity : constant space in dictionary

        '''
        - DO NOT THINK OF SWAPPING
        - just count the number of

        very good edge case:
        S = "cbafg", T = 'abcd'
        'abcfd'  'cabddeefde' (all in s in t)
        'abcde'  'fghkab' ( all in s not in t)

        it is important to append all the remaining elem in S and T

        Problem :
        - DO not make mistake in space complexity, it is constant
        '''

        # count = collections.Counter(T) # convert words to dict OR use for loop
        ans = []
        dict = {}

        # create dict with chars in T
        for i in range(len(T)):  # O(n) # len of T = n
            if T[i] in dict:
                dict[T[i]] += 1
            else:
                dict[T[i]] = 1

        print(dict)

        # iterate through S to append all chars in order in T
        for char in S:  # O(m) # len of S = m
            if char in dict:
                ans.append(char * dict[char])  # works dict[char] times
                dict.pop(char)  # remove key once its appended to the string
            # no need of else
            # else:
            # continue

            # it is important to remove the keys because otherwise

        print(ans)

        #  append remaining chars from T to ans
        # again travrse through T and find elements in dict

        # here the elements removed previously from dict won't be appended
        for char in T:
            # ans.append(key*dict[key]) # we can use append or while loop
            if char in dict:
                while dict[char] > 0:
                    ans.append(char)
                    dict[char] -= 1
            # dict.pop(char) # no need to pop the key here, because it will try to look in dictionary the char which was popped previously, it will give key error

        print(ans)
        return "".join(ans)



