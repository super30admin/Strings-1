// Time Complexity : O(n) where n is length of string s
// Space Complexity : O(1) constant because at most only 26 chars
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @return {number}
 */

//sliding window sloution
var lengthOfLongestSubstring = function(s) {
    let charMap = new Map();
    let slow = 0;
    let max = 0;
    for(let i = 0; i < s.length; i++) {
        char = s.charAt(i);
        if(charMap.has(char)) {
            slow = Math.max(slow,charMap.get(char));
        }
        max = Math.max(max, i - slow + 1)
        charMap.set(char,i+1);
    }
    return max;
};