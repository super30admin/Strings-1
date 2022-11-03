// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity : O(n)
// Space Complexity : O(n) For Hashmap

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    if (s === null || s.length === 0)
        return 0;

    let max = 0;
    let map = new Map();
    let start = 0;

    for (let end = 0; end < s.length; end++) {
        let ch = s[end];
        if (map.has(ch)) {
            // If ch is already encountered, move start to its index+1 id it is more than start itself
            // If it is less, ignore
            start = Math.max(start, map.get(ch) + 1);
        }
        // Set ch and index
        map.set(ch, end);
        // Calculate max length at each point
        max = Math.max(max, end - start + 1);
    }
    return max;
};