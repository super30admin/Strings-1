
//## Problem2 

//Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)


//TC= O(n)
//SC- O(1)

//  Approach: Sliding window and 2 pointers -
//Keep a slow(or start of result string) and fast ( end of result string) pointer , as we process a character, put its next index into map 
// and then check if it repeats or not as we want unique characters

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char,int> m1;
        int max_length = 0;
        int curr_length = 0;
        
        int i =0;
        
        int slow= 0, fast=0;
        vector<string> results;
        
        for(int i=0; i< s.size() ;i++){
            
            
             fast = i;
             if( m1.find(s[i]) != m1.end()){
                 slow = max(slow, m1[s[i]]);
                 
             } 
            m1[s[i]] = i+1;
            curr_length = fast - slow +1;
            if(curr_length > max_length){
                    max_length = curr_length;
                    if(results.size() > 0)
                        results.pop_back();
                    results.push_back( s.substr(slow, fast-slow +2));
                    
            }   
            else if (curr_length == max_length){
                results.push_back( s.substr(slow, fast-slow +2));   
            }
            
        }
        
        for(int j=0; j < results.size() ; j++){
            cout<< results[j] <<endl;
        }
        return max_length;
        
    }
};