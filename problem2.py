#Longest Substring Without Repeating Characters

# // Time Complexity :  O(N) 
# // Space Complexity : O(1)- as the max elements will only be 26 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def lengthOfLongestSubstring(self, s: str) -> int:
    #hashmap method
    maxi=0
    first_pointer= second_pointer=0
    num_set={}
    while(second_pointer<len(s)):
        if(s[second_pointer] in num_set):                       #if the element on the secnod pointer is in the hashmap already, you know its repeated
            first_pointer=max(first_pointer,num_set[s[second_pointer]] )        #you take the first pointer to either the index after it occured before, or where first pointer already is, depending onn which one is greater
        maxi = max((second_pointer-first_pointer)+1, maxi)              #update the length of the longest substring
        num_set[s[second_pointer]] = second_pointer+1                   # update the the index of the second pointer
        second_pointer+=1
    return maxi