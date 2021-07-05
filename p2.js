// ## Problem2 

// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

const lengthOfLongestSubstring = function(s) {
    if(s.length === 0 || !s) return 0;
    let map = new Map(), max = 0, slow = 0;
    for(let i = 0; i < s.length; i++) {
        if(map.has(s[i])) {
            slow = Math.max(slow, map.get(s[i]));
        }
        max = Math.max(max, i - slow + 1);
        map.set(s[i], i+1);
    }
    return max;
};