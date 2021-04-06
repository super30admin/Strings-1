//TC: O(n + m) where n and m are lengths of strings s and t respectively
//SC: O(m) where m is length of string t.


class Solution {
public:
    string customSortString(string S, string T) {
        int size=S.size();
        unordered_map<char, int>mp;
        
        //add characters of T to a hashMap with their counts
        for(auto c: T) 
            mp[c]++;
        
        //empty result string
        string str="";
        
        //iterate through S to check if values in s exist in the map. If yes, then add that character that many times to the new string. 
        for(char c: S){
            if(mp.find(c) != mp.end()){
                //string function is string(number of characters, character)
                str+=string(mp[c], c);
                //remove after adding all possible counts of this character to the map
                mp.erase(c);
            }
        }
        
        //add the remaining characters in the map to the string
        for(auto m:mp){
            str+=string(m.second, m.first);
        }
        return str;
    }
};