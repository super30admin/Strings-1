// Time Complexity : O(n); n is length of T
// Space Complexity : O(1); 26 entries at most 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Iterate through input string T and add each char and its count in map
// 2. Go through custom sorted string S and if char in S is present in T, add that char to result as many times as it is present in input
// 3. Now, common chars between S and T is over. Add remaining chars of input T to result as many times as it is present in input

class Solution {
public:
    string customSortString(string S, string T) {
        if(S.size()==0 || T.size()==0)
            return T;
        map<char, int> hash;
        for(char c: T)
            hash[c]++;
        string result;
        for(char c: S){
            if(hash.find(c) != hash.end()){
                int count=hash[c];
                for(;count>0;count--)
                    result.push_back(c);
                hash.erase(c);
            }
        }
        for(auto el: hash){
            char c = el.first;
            int count = el.second;
            for(;count>0;count--)
                result.push_back(c);
            hash.erase(c);
        }
        
        return result;
    }
};