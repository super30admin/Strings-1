#First Solution
#  Time Complexity : O(m + n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : Store all the characters of string s in the sMap dictionary. Iterate through the order string and get the count of that character from the sMap to maintain the order. Append all the counts of this character to the res string. Now just add all the elements that are not in order but are present in str to the res string.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        sMap = dict()
        for i in s:
            if i not in sMap:
                sMap[i] = 0
            sMap[i] += 1
        
        res = ""

        for i in order:
            count = sMap.get(i, 0)
            res += i * count
            sMap.pop(i, None)
        
        for key, value in sMap.items():
            res += key * value
        
        return res

#Second Solution
#  Time Complexity : O(M + NlogN) M -> length of order, NlogN -> Time for sorting
#  Space Complexity : O(M + N)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : Store the characters of the order string in a hashmap with the character as the key and the index as the value. Convert the string s to a list. Sort the list arr based on the index received from the hashmap with the characters not present in order string going at the end. Convert the sorted list to an array
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        sortedOrder = {char : i for i, char in enumerate(order)}

        arr = list(s)

        arr.sort(key = lambda x: sortedOrder.get(x, -1))

        return ''.join(arr)