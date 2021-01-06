
//## Problem1 
//Custom Sort String (https://leetcode.com/problems/custom-sort-string/)


//TC- O(S.size() + T.size())
//SC- O(1)

//  Approach: Use hash map to keep track of character in T and then traverse through S and check T has all characters or not. 
//  Keep on building the string on the way


class Solution {
public:
    string customSortString(string S, string T) {
        
        
        unordered_map<char, int> m1;
        unordered_map<char,int> ::iterator it;
        string result;
        
        for(int i=0 ; i< T.size(); i++){
            
            if(m1.find( T[i]) == m1.end()){
                m1[T[i]] = 1;
            }
            else{
                m1[T[i]] += 1;
            }
        }
        
     
        for(int i=0; i< S.size(); i++){
            
            
            if( m1.find(S[i]) != m1.end()){
          
            
                int times= m1[S[i]];
                for(int j=0; j< times; j++){
                    result += S[i];
                }
               //erase that key
                 m1.erase(S[i]);
            }
        }
        
        // for(it=m1.begin() ; it != m1.end(); it++){
        //     cout<< "helloo" << endl;
        //     char ch =  it->first;
        //     int times= it->second;
        //     cout<< ch << " " << times << endl;
        // }  
        
        // unordered_map<char,int> iterator it;
        // unordered_map<char,int> ::iterator it;
        
        for(it=m1.begin() ; it != m1.end(); it++){
            char ch =  it->first;
            int times= it->second;
            //cout<< ch << " " << times << endl;
            for(int j=0; j< times; j++){
                result += ch;
            }
        }
        return result;
        
    }
};