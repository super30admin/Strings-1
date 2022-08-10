class Solution:
    def customSortString(self, order: str, s: str) -> str:
        '''
        Algorithm:
        1. Create a counter for the input string 
        2. Iterate over the order and append the value to the list by the frequency of times it occurs 
        After each additon to the list, make its count as 0 to remove it from the counter 
        3. finally iterate over the counter to append the remianing elements into the list and return the list in the form of a string. 
        Time Complexity = O(N)
        Space Complexity = O(N)
        '''
        c = Counter(s)
        # print(c)
        r = []
        for i in order:
            r.append(i*c[i])
            c[i] = 0
            
        for i in c:
            r.append(i*c[i])
        return ''.join(r)
