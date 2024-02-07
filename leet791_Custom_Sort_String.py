# Solution

# // Time Complexity : Optimized: O(m) m is the length of string, the order array can be max of 26 so it will be constant
# // Space Complexity : O(1) since at max there can be just 26 characters
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Optimized Solution: Iterate over string once by saving frequency of each characters in dictionary. Once done, iterate over the 
# order array and print the each character of order by taking the frequency from dictionary. Rest of the characters which are
# not in the order array can be printed in any order
# Bruteforce Approach: Is checking all possibilites to see if the pattern matches

def customSortString(order,s):
    charDict = {}
    result = ""

    for c in s:
        if c in charDict:
            charDict[c] += 1
        else:
            charDict[c] = 1
    
    for c in order:

        if c in charDict:
            count = charDict[c]

            while count>0:
                result += c
                count -= 1
            del charDict[c]
    
    for charDictitem in charDict.items():
        c = charDictitem[0]
        count = charDictitem[1]
        while count>0:
            result += c
            count -= 1
    
    return result

if __name__ == "__main__":
    order = "cbafg"
    s = "abcd"
    print(customSortString(order,s))        