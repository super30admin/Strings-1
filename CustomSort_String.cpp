// Time Complexity : O(n) for travelling complete through string
// Space Complexity : O(k) for the hashmap. where k is unique characters in given string.. it is o(1) if we define it with specific legth
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    string customSortString(string S, string T) {
        map<char, int> mymap;
        
        string result;
        
        // creating the map with frequencies of all chars in T
        for( int i = 0 ; i < T.size(); i++){
            mymap[T.at(i)] +=1;
        }
        
        // appending the chars of string S in order for the frequescies in map
        for (int i = 0; i < S.size(); i++){
            
          
            if(mymap.find(S.at(i)) != mymap.end()){
                int k = mymap[S.at(i)];
                for ( int j = 0; j < k; j++ ){
                    mymap[S.at(i)] -=1;
                    result.push_back(S.at(i));
              
                }
            }
            
        }
        
        // appending the remaining values from the map
        for( auto k: mymap){
            
            for ( int i = 0; i < k.second; i++){
                
                result.push_back(k.first);
            }
        }
        
        return result;
    }
};