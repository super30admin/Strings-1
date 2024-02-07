// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using hashmap to store the freq of the chars in s. 
// Iterate through the order string and append it to ans and then finally appending
// the remaining chars in s;

// 791. Custom Sort String

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    string customSortString(string order, string s) {
        string res="";
        map<char,int> mp;
        for(auto i : s){
            mp[i]++;
        }
        for(int i=0;i<order.length();i++){
            if(mp.find(order[i]) != mp.end()){
                int val = mp[order[i]];
                while(val){
                    res += order[i];
                    val--;
                }
                mp[order[i]] = 0;
            }
        }
        for(auto a : s){
            if(mp[a]!=0){
                res += a;
            }
        }
        return res;
    }
};