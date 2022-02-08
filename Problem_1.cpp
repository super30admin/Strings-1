/**
 * Time Complexity:
 * O(m + n) where m and n are the sizes of the order
 * and string respectively. First we are iterating the
 * string to create a frequency map which gives us 
 * O(m). Then we iterate over the order string to
 * look for values in the map which gives us O(n).
 * Then we iterate again over the remianing chars in the
 * map which gives us O(m) in worst case. 
 */

/**
 * Space Complexity:
 * The space complexity is O(1).
 */

/**
 * Approach:
 * We are creating a frequency map of the given string. Then we check is the character
 * from order is in map or not. If present, then take its frequency and append it equal
 * to frequency times to the result and then remove it from map.
 * 
 */

//The code ran perfectly on leetcode


class Solution {
public:
    string customSortString(string order, string s) {
        
        //creating the frequency map for strings
        unordered_map<char, int> store;
        string ans= "";
        
        for(int i =0; i< s.size(); i++){
            if(store.find(s[i]) == store.end()){
                store.insert(make_pair(s[i], 1));
            } else {
                store[s[i]]++;
            }
        }

        //checking if the character from order is in map
        //or not. If present, then take its frequency and
        //append it equal to frequency times to the result 
        //and then remove it from map.
        for(int i = 0; i < order.size(); i++){
            if(store.find(order[i]) != store.end()){
                int freq = store[order[i]];
                for(int j =0; j< freq; j++){
                   ans.push_back(order[i]);
                }  
                store.erase(order[i]);
            }
        }
        
        //append the remaining characters to the answer
        for(auto remChar : store){
            int freq = remChar.second;
            for(int i =0; i< freq; i++){
                ans.push_back(remChar.first);
            } 
        }
        return ans;
    }
};