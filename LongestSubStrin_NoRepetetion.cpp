// Time Complexity : O(n) for traversin throught the string completely
// Space Complexity : O(k) for the hashmap. where k is unique characters in given string.. it is o(1) if we define it with specific legth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int size = s.size();
        
        if(s == "") return 0;
        int result = INT_MIN;
        // using sliding winndow method..
        
        //1. r will move forard by adding the char and r +1 to the hashmap.
        // 2. s will be set to that position as soon as r hits the existing element
        // before this we will update the result als to get largest length.
        // to avoud the s to go back to previous positions which alredy travelled
        // we use max(hashval, s).... so that to  make sure we are only checking for values in between s and r.

        int l = 0;
        int r = 0;
        
        map<char, int> myhash;
        
        while(r < size){
            
            char ch = s.at(r);
            if(myhash.find(ch) != myhash.end()){
                
                l = max(l, myhash[ch]);
                
                myhash[ch] = r+1;
            }else{
        
            myhash.insert({ch,r+1});
        }
            
            result = max(result, (r- l) +1 );
         
            r +=1;
            
        }
        
        
        
        return result;
    }
};