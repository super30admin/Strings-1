'''
Problem: Custom Sort String
Time Complexity: O(n) where n is character in s
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        take frequency map
        add characters from order in th eresult first
        then add rest of characters in the result
'''

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dicts = Counter(s)
        result = ''

        for i in range(len(order)):
            if order[i] in dicts:
                result+=order[i]*dicts[order[i]]
                del dicts[order[i]]
        
        for key, val in dicts.items():
            result+=key*val

        return result
        

