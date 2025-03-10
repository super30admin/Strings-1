// https://leetcode.com/problems/custom-sort-string/description/
// Time Complexity : O(n+m) where n is the length of the order and m is the length of the string s
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store the characters in s in a hashmap along with frequency.
// Now, check the elements that are present in order as well as hashmap. Add them to the result. Erase that element from the map
// Iterate through the map and append the rest of the characters in the map.

class Solution {
    public:
        string customSortString(string order, string s) {
            string res;
            unordered_map<char, int>mp;
            for(auto i: s){
                mp[i]++;
            }
            for(auto i:order){
                if(mp.find(i) != mp.end()){
                    res.append(mp[i],i);
                    mp.erase(i);
                }
            }
            for(auto i:mp){
                res.append(i.second, i.first);
            }
            return res;
        }
    };