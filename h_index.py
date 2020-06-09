
#Problem 3: h-index
#Time Complexity: O(nlogn)
#Space ComplexityL O(1)
'''
We notice that that since h index is the number such that
h papers have more or equal than h citations, we cannot have an
H index bigger than
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        if min(citations)>len(citations):
            return len(citations)

        citations.sort(reverse=True)
        print(citations)
        for i,c in enumerate(citations):
            if c<=i:
                return i
        return citations[-1]



#Time Complexity: O(n)
#Space Complexity: O(n)
'''
We notice that that since h index is the number such that
h papers have more or equal than h citations, we cannot have an
H index bigger than N , since we only have N papers. This means,
that we only need to sort the elements smaller or equal to N.
Further more, we can guarantee that these elements are smaller
than N, so count sort will run at O(n). Once we sorted we do
the same thing from reverse.
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        if min(citations)>len(citations):
            return len(citations)

        count={i:0 for i in range(len(citations)+1)}
        for c in citations:
            if c in count:
                count[c]+=1
        possible=[]
        for i in range(len(citations)+1):
            for j in range(count[i]):
                possible.append(i)
        index_last=len(citations)-len(possible)

        #Traversing from index_last to index=len(citations)-1
        #So it's like we are traversing in reverse for the
        #Sorted array, while we ignored the ones bigger than N
        #For possible we iterate from last element to one,
        #Our real index is index_last+i in the sorted descending array
        i=0
        while i<len(possible):
            if possible[len(possible)-1-i]<=index_last+i:
                return index_last+i
            i+=1

        return citations[-1]
