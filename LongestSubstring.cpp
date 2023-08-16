//timeO(n)
//space(O(1)


/*
directly finding the longest substring without finding all the substrings, whenever we find
a repeating character we move the slow pointer to the index of repeating character stored in
the hash map +1, we will comparing the maximum and finally return the longest substring.
*/

class Solution {
public:
    
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> occur;
        
        
        int slow =0;
        
        int fast = 0;
        int maxi=0;

        while(fast<s.size()){
            char c = s[fast];
            
            if(occur.find(s[fast])!=occur.end()){
                
                    
                    if(occur[c]+1>slow)
                       { slow = occur[c]+1;}
                                    
                
            }
            occur[c]=fast;
            
            
            
            if((fast-slow+1)>maxi){
                maxi = (fast-slow)+1;
            }
            fast++;
            
            

        }
        return maxi;

    }
};