TC - O(n)
SC - O(1)

/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function(order, s) {
    var map = new Map();
    for(let i=0;i<order.length;i++)
    {
        map.set(order[i],i);
    }
    var st=[];
    for(let [k] of map.entries())
    {
       for(let i=0;i<s.length;i++){
        if(s[i]===k && map.has(s[i]))
        {
           st.push(s[i]);
        }
        else if(!map.has(s[i]))
        {
            map.set(s[i],1);

        }
       }
    }
    return st.join('').toString();
};