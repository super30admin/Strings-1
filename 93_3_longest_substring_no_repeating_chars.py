# done on July 19
# understand sliding window
# yet to try hash set

# Method 1 : All combinations : O(n^2)

# Method 2 : Hash set O(2n)

# Method 3 : Hash map O(n)


'''
cases : zbxybczba
- when fast reaches z , slow reaches x  and z is already in hashmap
- we can ignore z if index of exsting z in hasmap is lower than index of x ( slow ptr)
- MAX : ( 1 ,2 ) --> ( curr value of slow i.e index 2 ) > ( val of z i.e 1 ) hence we keep slow ptr at 2
'''


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        # Method 3 : Hash map O(n) ( two pointers slow and fast)
        # Time complexity : O(n)
        # Space complexity : constant space O(26)

        '''
        - think of sliding window on only one side
        - not back and forth
        - start slow and fast at the same place
        - stopping condition : fast should not go ou of bound
        - if dupicate found : 1. move slow ptr, 2. update val for char in map

        Problem :
        - store index+1 in the hashmap; so that we can go to the val in hashmap when duplicate is encountered
        i.e move slow to duplicate elem index + 1
        - important step : between curr index of slow and value in dict we take max value
        '''

        if s == None or len(s) == 0: return 0

        dict = {}
        max_count = 0
        slow = 0
        fast = 0

        # stopping condition
        while fast < len(s):
            c = s[fast]  # grap 1st char
            if c in dict:  # if duplicate found
                # first :  move slow
                slow = max(slow, dict[c])  # this is important, taking max
            dict[c] = fast + 1  # second step : put index+1 in hashmap
            max_count = max(max_count, fast - slow + 1)
            fast += 1

        print(max_count)
        return max_count

    # Method 1 : Take all substrings and check for no repeating chars
    # Time complexity : O(n)
    # Space complexity : O(n) [ space in set ]

    '''

        if len(s) == 0:
            return 0

        if set(s) == 1:
            return 1


        curr_length = 0
        for i in range(len(s)):
            #print(i)
            for j in range(i,len(s)+1):
                #print('j',j)
                #print(s[i:j])
                #print(set(s[i:j]))
                if len(s[i:j]) == len(set(s[i:j])): // Does this take O(n) also ?
                    #print('unique',s[i:j])
                    new_length = len(s[i:j])
                    if new_length > curr_length:
                        curr_length = new_length
                #print('add',s[i:j] ,curr_length)


        #print(curr_length)
        return curr_length

    '''