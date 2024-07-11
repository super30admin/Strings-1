# Time Complexity:
# O(m+n), m = lentght of "order", n = lenght of "s"

# Space Complexity:  
# O(1),   Even though we create a hashMap, the max elements it could have is 26(due to lowercase alphabets)     

# Approach: 
# Heap, Use the min heap, while limiting the capacity of min heap elements to "k"

class Solution(object):    # TC ==> O(m+n), SC ==> O(1)
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        if not s or len(s)==0:
            return ""

        # store the occurence of char of "s" in map
        hashMapS = {}

        for c in s:
            if c in hashMapS.keys():
                hashMapS[c]+=1
            else:
                hashMapS[c]=1
        
        #print("Hashmap:", hashMapS.keys(), " ", hashMapS.values())

        result = ""
        for i in range(0, len(order)):
            if order[i] in hashMapS.keys():
                times = hashMapS[order[i]]
                for n in range(times):
                    result += order[i]
                del hashMapS[order[i]]

        # process remaining key-value pair in the map
        for key in hashMapS.keys():
            times = hashMapS[key]
            for n in range(times):
                result += key
        
        return result
        
