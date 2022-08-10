class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        '''
        maintain a hash map to record the indexes of the incoming element 
        if the incoming element is already present in the hash map, then 
        move the start index to the next index of the repeating element 
        for each iteration, maintain, the length of the string and compare it with the 
        global longest 
        Time complexity = O(N)
        Space Complexity = O(M) -- M - the size of the longest substring --> M <= N
        '''
        set_ = set([])
        l = 0 
        max_len = 0
        longest_substring = ""
        for idx, val in enumerate(s):
            while s[idx] in set_:
                set_.remove(s[l])
                l += 1
            set_.add(s[idx])
            max_len = max(max_len, len(set_) )
        return max_len
            
