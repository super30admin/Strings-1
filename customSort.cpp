"""
Intuition: Cout all the characters in the original string and put it in a hashmap.
Push all the characters from this hashmap to the result string using the order string.
Push the remaining letters from the original string to the result.
#####################################################################
Time Complexity : O(M+N) 
Space Complexity : O(N), N = length of the original string.
#####################################################################
"""

class Solution {
public:
    string customSortString(string order, string str) {
        map<char, int> count;
        string result;
        for ( auto letter:str ){
            count[letter] += 1;
        }
        
        for ( auto letter: order){
            if ( count.find(letter) != count.end()){
                for ( int i =0; i < count[letter]; i++){
                    result += letter;

                }
                count.erase(letter);
            }
        }
        
        for ( auto letter: order){
            if ( count.find(letter) != count.end()){
                for ( int i =0; i < count[letter]; i++){
                    result += letter;

                }
                count.erase(letter);
            }
        }
        for ( auto keyValuePair: count){
            char letter = keyValuePair.first;
            for ( int i =0; i < count[letter]; i++){
                result += letter;

            }
            count.erase(letter);
        }
        return result;
    }
};