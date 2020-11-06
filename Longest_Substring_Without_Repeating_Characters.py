class Solution:
    '''
    Brute force:
    2 loops one loop to iterate through whole string, second loop to check if the letter is already present 
    in non_repeating list
    Time Complexity - O(N^2)
    Space Complexity - O(N)
    
    #Approach 2
    Sliding window approach:
    
    Time Complexity - O(n)
    Space Complexity - O(n)
    
    Step 1: Define start and max_length variable and initialize it with 0
    Step 2: Define a dictionary (This will help up in checking if the letter already occured and
            to get to the next letter to the dupilicated letter)(In non_rep_dict, key is the letter              
            and value is the last position at which it occured )
    Step 3: Initiate a loop for length of input string.
    Step 4: Check if the letter is present in non_rep_dict and start is less than non_rep_dict[s[i]],
            update start with non_rep_dict[s[i]]+1
            Else update max_length with max(max_length,i-start+1)
    Step 5: Update the value of that letter which is key in non_rep_dict with its occurence position index
    
    Code accepted on leetcode
    '''
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        max_length = 0
        start = 0
        
        non_rep_dict = {}
        
        for i in range(0,len(s)):
            if s[i] in non_rep_dict and start <= non_rep_dict[s[i]]:
                start = non_rep_dict[s[i]]+1
            else:
                max_length = max(max_length,i-start+1)
                
            non_rep_dict[s[i]]=i
            
        return max_length
        
        

