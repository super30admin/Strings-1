#custom sort string
# // Time Complexity :  O(max(s,order)) 
# // Space Complexity : O(1) as the max elements will only be 26
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def customSortString(self, order: str, s: str) -> str:
    s_map={}
    for i in s:
        s_map[i]=s_map.get(i, 0)+1          #add the count of the s strings to a hashmap
    
    s=""
    for i in range(len(order)):             #for each string in the order, check if its in the hashmap, 
        if (order[i] in s_map):             #if it is, then add the number of times it exists to the returning string
            count = s_map[order[i]]
            while(count!=0):
                s+=order[i]
                count-=1
            s_map.pop(order[i])
    
    for i in s_map:                         #then add the remaining strings to the returning variable
        count = s_map[i]
        while(count!=0):
            s+=i
            count-=1
    return s