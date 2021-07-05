// ## Problem1 
// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(N x count)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

const customSortString = function(S, T) {
    let map = new Map(), res = '';
    for(let c of T) {
        map.set(c, (map.get(c) || 0) + 1);
    }
    for(let c of S) {
        if(map.has(c)) {
            while(map.get(c) > 0) {
                res += c; 
                map.set(c, map.get(c) - 1 )
            }
            map.delete(c);
        }
    }
    for(let [k,v] of map) {
        while(map.get(k) > 0) {
            res += k;
            map.set(k, map.get(k) - 1)
        }
    }
    return res;
};