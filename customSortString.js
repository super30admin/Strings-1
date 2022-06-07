// Time Complexity : O(m + n) where m is length of order string and n is length of s string
// Space Complexity : O(1) constant because at most only 26 chars
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function(order, s) {
    let hashMap = new Map();
    let output = '';
    
    //create a hash map where key is character of a string and value is character count in the string
    for(let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        let count = 0;
        if(hashMap.has(c)){
            count = hashMap.get(s.charAt(i));
            hashMap.set(s.charAt(i),count+1);
        } else {
            hashMap.set(s.charAt(i),count+1);
        }
    }
    
    //build the output string with the order character (take character count from hashmap)
    //part of order string
    for(let i = 0; i < order.length; i++) {
        let c = order.charAt(i);
        if(hashMap.has(c)) {
            let count = hashMap.get(c);
            while(count !== 0) {
                output += c;
                count--;
            }
            hashMap.delete(c);  
        } 
    }
    
    //add rest of the char in the output string (take character count from hashmap)
    //not part of order string
    for(let c of hashMap.keys()) {
        let count = hashMap.get(c);
        while(count !== 0) {
            output += c;
            count--;
        }
        hashMap.delete(c);
    }  
    return output;
};