/**
 * Time Complexity:
 * O(n) as we are using sliding window approach and are iterating over the string
 * only once.
 * 
 */

/**
 * Space Complexity:
 * O(1) as we are not creating any extra space for calculations.
 * 
 */

/**
 * The first intution is brute force. But it is giving me nested solution
 * with O(n^2) time complexity which means I can use three techniques 
 * like hashing, sliding window and two pointers. 
 * 
 * We are using the sliding window approach here with hash map. Hash map is
 * used to keep the track where the element occurred in the string. We are
 * using occurrence + 1 appraoch, so that it escapes the repeated element's
 * first occurrence when we encounter a repeated element. We also have
 * to update the occurrence with the new occurrence.
 * 
 * To care of repeated element which is repeating but out of window, i.e.,
 * to the left of the window, we have to ignore the index of the char
 * with the index stored in the map. If the the index stored is smaller then
 * we ignore it
 * 
 */


// The code ran perfectly on leetcode



class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> store;
        int slow = 0;
        int maxL = 0;
        for(int i = 0; i<s.size(); i++){
            char c = s[i];
            if(store.find(c) != store.end()){
                
                slow = max(slow, store[c]);
            } 
                store[c] = i+1;
            maxL = max(maxL, i- slow +1);
            
        }
        return maxL;
    }
};