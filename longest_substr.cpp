//TC: O(n)
//SC: O(n) where n is the number of elements


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int len = s.length();
        
        unordered_map<char, int> map;
        
        int result = 0;
        
        for(int i=0, j=0; j<len; j++){
            
            if(map.find(s[j])!=map.end()){
                //here our start point would be the maximum value between the current start point and the index of the previously occuring value +1 (as this is what was added to the map)
                i = max(map[s[j]], i);
            }
            
            result =  max(result, j-i+1);
            //so that we do not have to step one by one till the previous occurence of the repeating character, we add the j+1th index as the value for the jth character
            map[s[j]] = j+1;
            
        }
        
        return result;
        
        
        
        // int len=s.length();
        // unordered_map<char,bool> um;
        // int low=0,max_len=0;
        // for(int high=0;high<len;high++){
        //     while(um[s[high]]==true){
        //         um[s[low++]]=false;
        //     }
        //     um[s[high]]=true;
        //     if(high-low+1>max_len)
        //         max_len=high-low+1;
        // }
        // return max_len;
    }
};