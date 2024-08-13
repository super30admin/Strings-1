class Solution:
    """
    Time Complexity: O(M+N) ~ O(N), as string "order" has unique char only, so
    max val of M = 26 which is a constant.
    Space Complexity: O(N), where N len of string s. 
    """
    def customSortString(self, order: str, s: str) -> str:
        # Edge case: If the order string is None or empty, return the original string s
        if order == None or len(order) == 0:
            return s
        
        # Dictionary to count occurrences of each character in s
        myDict = {}
        result = []
        
        # Populate the dictionary with the frequency of each character in s
        for char in s:
            if char not in myDict:
                myDict[char] = 0
            myDict[char] += 1
        
        # Add characters to the result list in the order specified by the 'order' string
        for char in order:
            if char in myDict:
                val = myDict[char]
                for i in range(val):
                    result.append(char)
                # Once a character is added to the result, remove it from the dictionary
                del myDict[char]
        
        # Add remaining characters (that were not in 'order') in their original frequency
        for key, value in myDict.items():
            for i in range(value):
                result.append(key)
        
        # Join the list of characters into a final string
        return "".join(result)

        # This return is unreachable; the function ends at the previous return
        return s
