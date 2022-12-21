// Time Complexity : O(m+n) Iterating over both the strings
// Space Complexity : O (1) Hashmap max size is 26
// Did this code successfully run on Leetcode : Yes 

/*
Iterate over the string s and create a map to record the count of each character
Iterate over the order and add the letters * count to the output 
add the rest of the chars to the result
*/

class Solution {
public:
    string customSortString(string order, string s) {
        if(order.length() == 0 || s.length() == 0) return s;

        unordered_map<char, int> sMap;

        // creating a map of the input string
        for(char c: s)
            sMap[c] ++;
        
        string result;

        // output the letter till count becomes 0 in the order given in input
        for(char c: order){
            if(sMap.find(c) != sMap.end()) {
                while(sMap[c] > 0){
                    result += c;
                    sMap[c]--;
                }
                // remove the key from map once the count is 0
                if(sMap[c] == 0)
                    sMap.erase(c);
            }
        }
        // iterate over the map and add the letters not in 'order' to the result
        for(auto it: sMap) {
            while(it.second > 0) {
                result += it.first;
                it.second --;
            }  
        }
        return result;
    }
};