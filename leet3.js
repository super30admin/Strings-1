TC - O(N)
 SC - O(1)

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let map= new Map();
    let l=0;
    for(var i=0,j=0;i<s.length;i++)
    {
        if(map.has(s[i]))
        { 
            j=Math.max(map.get(s[i]),j); 
        }
        l = Math.max(l,i-j+1);
        map.set(s[i],i+1);
    }
    return l;
};