// Time Complexity : O(m + n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Custom sort string

#include<vector>
#include<iostream>
#include<unordered_map>

using namespace std;

class Solution {
public:
    string customSortString(string order, string str) {
        
        // put everything of the second string in the hashmap 
        unordered_map<char, int> m1;
        
        string res = "";
        
        for(int i = 0; i < str.size(); i++){
            if(m1.find(str[i]) != m1.end()){    // if found 
                m1[str[i]] += 1;
            }
            else{
                m1[str[i]] = 1;
            }
        }
        
        for(int j = 0; j < order.size(); j++){
            if(m1.find(order[j]) != m1.end()){
                while(m1[order[j]] != 0){
                    res = res + order[j];
                    m1[order[j]] -= 1;
                }
                m1.erase(order[j]);
            }
        }
        
        for(auto itr : m1){
            while(itr.second != 0){
                res = res + itr.first;
                itr.second -= 1;
            }
        }
        
        return res;
    }
};