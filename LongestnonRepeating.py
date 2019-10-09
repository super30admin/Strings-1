"""
The logic here is to maintain a hashmap and the particular index of the characters, intially the start
and maxlen are both 0  now while iterating through the string if the letter is found in the dict then we
update out max to max of old maxlen or start - current index, in this way we are maintaining the maxlen
as soon as a char is being repeated and we also also update our start to the letter +1 index since we saw
the old start again hence the letter is repeated. In this way we find the max len string with non repeating
char and the last return statment handles the condtion when we are out of the loop but the last sub-sequence
is the max string with non repeating.

Space complexity - O(N)
Time complexity - O(N)
Leetcode - running
"""
def lengthOfLongestSubstring(self, s):
        lenMax = 0
        start = 0
        dic = {}
        for i, letter in enumerate(s):
            if letter in dic:
                lenMax = max(lenMax, i - start)
                start = max(start, dic[letter] + 1)
            dic[letter] = i
        return max(lenMax, len(s) - start)