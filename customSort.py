"""
Count frequencies of characters in s
Append it freq times ,for each char in order
Add rest of s's characters not in order
"""

from collections import Counter

class customSort:
    def customSortString(self, order: str, s: str) -> str:
        count = Counter(s)
        result = []

        for char in order:
            if char in count:
                result.append(char * count[char])
                del count[char]
        
        for char, freq in count.items():
            result.append(char * freq)

        return ''.join(result)


if __name__ == "__main__":
    obj = customSort()

    print(obj.customSortString("cba", "abcd"))  
    print(obj.customSortString("kqep", "pekeq")) 
