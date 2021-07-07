//
// Created by shazm on 8/19/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> hashmap;
        int retVal = 0; int i = 0; int j = 0;
        while(i<s.size() && j<s.size()){
            if(hashmap.find(s[j])==hashmap.end()){
                hashmap.insert(s[j]); j+=1;
                retVal = max(retVal, j-i);
            }else{
                hashmap.erase(s[i]); i+=1;
            }
        }
        return retVal;
    }
};

int main(){
    return 0;
}