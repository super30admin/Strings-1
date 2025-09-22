#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Using a hashmap we store the frequency of all the characters in s inside
the map, then while iterating through order string we append the result variable
and erase that character present in the map and which is also present in order
then we append the remaining letters from char and return the result
*/
class Solution{
public:
    string customSorting(string order, string s){
        string result = "";
        unordered_map<char, int> map;
        for(auto& c : s) map[c]++;

        for(auto& c : order){
            if(map.find(c) != map.end()){
                result.append(map[c], c);
                map.erase(c);
            }
        }

        for(auto& c : map){
            result.append(c.second, c.first);
        }
        return result;
    }
};
