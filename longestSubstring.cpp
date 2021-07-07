// Time Complexity : O(n); n is length of string
// Space Complexity : O(1); Max 26 entries in map and 2 pointers only 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Sliding window with i and j =0 at start. Increase j till it reaches end and add char at j and index j to map 
// 2. If char at end pointer (j) not found in current window (between i and j), update result length
// 3. Else if a char is found in the window, move start pointer to 1 plus last found position of that char

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i=0,j=0,result=INT_MIN;
        int n = s.length();
        if(!n)
            return 0;
        map<char, int> tracker;
        while(j<n){
            // if char not found or found before start of curr window
            if(tracker.find(s[j]) == tracker.end() || tracker[s[j]]<i)
                result = max(result, j-i+1);
            // char already present in curr window, update the srt of window
            else
                i = tracker[s[j]]+1;
            tracker[s[j]] = j;
            j++;
        }
        return result;
    }
};