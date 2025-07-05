// # Strings-1

// ## Problem1 
// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

//TC : We loop through both the input but order will always be max 26 so thats a constant, we loop on s thats O(N)
//SC : Make an array of 26 chars again thats O(1)
var customSortString = function(order, s) {
    //TC : O(n)
    //SC : O(1)
    let hashMap = new Map()
    let res = []
    for(let char of s){
        hashMap.set(char,((hashMap.get(char) || 0) + 1))  
    }
    for(let char of order){
        if(hashMap.has(char)){
        for(let i=0;i<hashMap.get(char);i++){
            res.push(char)
        }
        hashMap.delete(char)
        }
    }
    //Loop over through rest of map
    for(let [key,value] of hashMap){
                for(let i=0;i<value;i++){
            res.push(key)
        }
    }
    return res.join("")
};
