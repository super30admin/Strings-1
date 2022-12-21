// Time Complexity : O(n) Iterating over the string
// Space Complexity : O (1) Hashmap max size is 26
// Did this code successfully run on Leetcode : Yes 

/*
Iterate over the string and add the index to a hashmap 
If a character is already seen, i.e, is already present in the map, update the start to the index + 1
Do this only if the index is greater than start, so we don't go back after the start has moved ahead 
Record result or max length at every instance 
*/


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length() == 0) return 0;
        unordered_map<char, int> seenChars;
        int start = 0;
        int result = 0;

        // iterate over the string
        for(int i=0; i<s.length(); i++){
        	// if the character is already seen
            if(seenChars.find(s[i]) != seenChars.end()) {
            	// if its within the window, and not before start
                if(seenChars[s[i]] >= start)
                	// update the start of window to the index after the last time the character was seen 
                    start = seenChars[s[i]] + 1;
            }

            // update the index and result in both cases 
            seenChars[s[i]] = i;
            result = max(result, i-start+1);
        }
        return result;
    }
};