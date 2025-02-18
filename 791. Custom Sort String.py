#space: O(1)
#time: O(size of the string)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        countmap= dict()
        final= ''
#creating count map
        for char in s:
            countmap[char]= countmap.get(char,0)+1
#adding char acc to order
        for o in order:
            if o in countmap:
                count= countmap[o]
                for i in range(count):
                    final += o
                countmap.pop(o)

#adding remaining chars in the map
        for remaining in countmap:
            count= countmap[remaining]
            for i in range(count):
                final += remaining
        return final
