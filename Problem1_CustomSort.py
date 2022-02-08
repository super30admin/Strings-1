#Time Complexity: O(m+n)
#Space Complexity: O(1)
#Leetcode: Yes

class Solutution:
    def customSortString(self, order, s):
        mapper, output = {}, ""
        for i in s:
            if i not in mapper:
                mapper[i] = 1
            else:
                mapper[i] += 1

        
        for i in order:
            if i in mapper:
                for j in range(mapper[i]):
                    output += i
                mapper.pop(i)
        
        for i in mapper:
            for j in range(mapper[i]):
                output += i
        
        return output

order = "cba"
source = "abcd"
obj = Solutution()
print(obj.customSortString(order,source))
